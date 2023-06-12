
package com.example.spedox_mobile;
import android.content.Intent;
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
import retrofit2.Retrofit;
import java.util.List;


/**

 Represents an activity for displaying a list of documents.
 Extends the AppCompatActivity class.
 */
public class Documents extends AppCompatActivity {

    /**
     * Called when the activity is created.
     * Initializes the activity and sets the content view to the layout resource file.
     * Retrieves the selected shipment from the intent extras.
     * Sets up the document list view and handles item click events.
     * Sets up the "Add Document" button and handles its click event to start the NewDocument activity.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        Button addDocumentButton = findViewById(R.id.new_document);

        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");

        List<DocumentModel> documents = selectedShipment.getDocuments();

        DocumentAdapter documentsAdapter = new DocumentAdapter(Documents.this, R.layout.activity_document_item, documents);

        ListView documentsListView = findViewById(R.id.documents_list_view);
        documentsListView.setAdapter(documentsAdapter);


        // helper function
        documentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                DocumentModel selectedShipment = documents.get(position);
                System.out.println("item clicked on positon" + position);
            }
        });

        addDocumentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Documents.this, NewDocument.class);
                intent.putExtra("selectedShipment", selectedShipment);
                startActivity(intent);
            }
        });
    }
}