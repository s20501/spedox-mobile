package com.example.spedox_mobile;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.adapters.DocumentAdapter;
import com.example.spedox_mobile.models.DocumentModel;
import com.example.spedox_mobile.models.ShipmentModel;

import java.util.List;

public class Documents extends AppCompatActivity {

    private DocumentAdapter documentsAdapter;
    private ShipmentModel selectedShipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        Button addDocumentButton = findViewById(R.id.new_document);

        selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");

        List<DocumentModel> documents = selectedShipment.getDocuments();

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
    protected void onResume() {
        super.onResume();


    }
}

