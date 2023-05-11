package com.example.spedox_mobile;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.models.ShipmentModel;

public class ShipmentDetails extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipments_details);

        TextView customerName = findViewById(R.id.client_name);
        TextView type = findViewById(R.id.type);

        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");
        customerName.setText(selectedShipment.getClientModel().getName());
        type.setText(selectedShipment.getStatus().status.toUpperCase());
    }
}