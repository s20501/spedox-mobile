package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.adapters.DocumentAdapter;
import com.example.spedox_mobile.conf.ApiManager;
import com.example.spedox_mobile.models.DocumentModel;
import com.example.spedox_mobile.models.ShipmentModel;
import com.example.spedox_mobile.services.ShippingServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;

public class Documents extends AppCompatActivity {

    private DocumentAdapter documentsAdapter;
    private ShipmentModel selectedShipment;
    private List<DocumentModel> documents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        Button addDocumentButton = findViewById(R.id.new_document);

        selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");

        documentsAdapter = new DocumentAdapter(Documents.this, R.layout.activity_document_item, documents);

        ListView documentsListView = findViewById(R.id.documents_list_view);
        documentsListView.setAdapter(documentsAdapter);

        documentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DocumentModel selectedDocument = documents.get(position);
                System.out.println("item clicked on position " + position);
            }
        });

        addDocumentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Documents.this, NewDocument.class);
                intent.putExtra("selectedShipment", selectedShipment);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            getAllShipments();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllShipments();
    }

    private void getAllShipments() {
        Retrofit retrofit = ApiManager.getRetrofitInstance();
        ShippingServiceApi shippingService = retrofit.create(ShippingServiceApi.class);

        Call<List<ShipmentModel>> call = shippingService.getAllShipments("Bearer " + getToken());

        call.enqueue(new Callback<List<ShipmentModel>>() {
            @Override
            public void onResponse(Call<List<ShipmentModel>> call, Response<List<ShipmentModel>> response) {
                if (response.isSuccessful()) {
                    List<ShipmentModel> shipments = response.body();
                    documents.clear();
                    for (ShipmentModel shipment : shipments) {
                        if (shipment.getId().equals(selectedShipment.getId())) {
                            documents.addAll(shipment.getDocuments());
                            break;
                        }
                    }
                    documentsAdapter.notifyDataSetChanged();
                } else {
                    // Handle request error
                }
            }

            @Override
            public void onFailure(Call<List<ShipmentModel>> call, Throwable t) {
                // Handle communication error
            }
        });
    }

    private String getToken() {
        SharedPreferences preferences = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE);
        return preferences.getString("AUTH_TOKEN", null);
    }
}
