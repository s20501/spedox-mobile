package com.example.spedox_mobile;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.spedox_mobile.models.ShipmentModel;
import org.w3c.dom.Text;

import java.util.Date;

public class ShipmentDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipments_details);

        TextView customerName = findViewById(R.id.client_name_detail);
        TextView type = findViewById(R.id.type_detail);
        TextView icotermDetails = findViewById(R.id.icoterm_detail);
        TextView blNumberDetails = findViewById(R.id.bl_number_details);
        TextView portOfLoadingDetails = findViewById(R.id.portOfLoading_detail);
        TextView dateOfLoading = findViewById(R.id.loading_date_detail);
        TextView portOfDestination = findViewById(R.id.port_of_destination_detail);
        TextView insurance = findViewById(R.id.insurance_detail);
        TextView shipper = findViewById(R.id.shipper_detail);
        TextView consignee = findViewById(R.id.consignee_detail);


        ShipmentModel selectedShipment = (ShipmentModel) getIntent().getSerializableExtra("selectedShipment");

        customerName.setText(selectedShipment.getClientModel().getName());
        type.setText(selectedShipment.getStatus().status.toUpperCase());
        icotermDetails.setText(selectedShipment.getIcoterms().icoTermenum.toUpperCase());
        blNumberDetails.setText(selectedShipment.getBlNumber());
        portOfLoadingDetails.setText(selectedShipment.getPortOfLoading());
        portOfDestination.setText(selectedShipment.getPortOfDestination());
        insurance.setText(selectedShipment.getValue() + " " + selectedShipment.getValueCurrency());
        consignee.setText(selectedShipment.getConsignee().getName());
        shipper.setText(selectedShipment.getShipper().getName());

        System.out.println(selectedShipment.getLoadingDate().toString());

    }
}