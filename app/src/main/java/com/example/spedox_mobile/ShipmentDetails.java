package com.example.spedox_mobile;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.models.ShipmentModel;

public class ShipmentDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipments_details);

        TextView customerName = findViewById(R.id.client_name_detail);
        TextView status = findViewById(R.id.status_detail);
        TextView icotermDetails = findViewById(R.id.icoterm_detail);
        TextView blNumberDetails = findViewById(R.id.bl_number_details);
        TextView portOfLoadingDetails = findViewById(R.id.portOfLoading_detail);
        TextView dateOfLoading = findViewById(R.id.loading_date_detail);
        TextView dateOfDestination = findViewById(R.id.destination_date_detail);

        TextView portOfDestination = findViewById(R.id.port_of_destination_detail);
        TextView insurance = findViewById(R.id.insurance_detail);
        TextView shipper = findViewById(R.id.shipper_detail);
        TextView consignee = findViewById(R.id.consignee_detail);


        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");


        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        customerName.setText(selectedShipment.getClientModel().getName());
        shipper.setText(selectedShipment.getShipper().getName());
        consignee.setText(selectedShipment.getConsignee().getName());
        status.setText(selectedShipment.getStatus().status.toUpperCase());
        icotermDetails.setText(selectedShipment.getIcoterms().icoTermenum.toUpperCase());
        blNumberDetails.setText(selectedShipment.getBlNumber());
        portOfLoadingDetails.setText(selectedShipment.getPortOfLoading());
        portOfDestination.setText(selectedShipment.getPortOfDestination());
        insurance.setText(selectedShipment.getValue() + " " + selectedShipment.getValueCurrency());
        dateOfLoading.setText(df.format(selectedShipment.getLoadingDate()));
        dateOfDestination.setText(df.format(selectedShipment.getDestinationDate()));



        System.out.println(selectedShipment.getLoadingDate().toString());

    }
}