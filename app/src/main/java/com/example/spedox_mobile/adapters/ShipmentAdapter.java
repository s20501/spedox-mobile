package com.example.spedox_mobile.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.spedox_mobile.R;
import com.example.spedox_mobile.models.ShipmentModel;

import java.util.List;

public class ShipmentAdapter extends ArrayAdapter<ShipmentModel> {
    private int resourceId;

    public ShipmentAdapter(Context context, int resourceId, List<ShipmentModel> items) {
        super(context, resourceId, items);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShipmentModel shipment = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(this.resourceId, parent, false);
        }

        TextView shipmentStatus = convertView.findViewById(R.id.shipment_status);
        shipmentStatus.setText(shipment.getStatus().status.toUpperCase());

        TextView blNumber = convertView.findViewById(R.id.bl_number);
        blNumber.setText(shipment.getBlNumber());

        return convertView;
    }
}
