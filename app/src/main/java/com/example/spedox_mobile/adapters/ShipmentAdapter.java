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


/**

 ArrayAdapter subclass for displaying ShipmentModel objects in a ListView.
 Provides custom views for each item in the list.
 */
public class ShipmentAdapter extends ArrayAdapter<ShipmentModel> {
    private int resourceId;

    /**
     * Constructs a new ShipmentAdapter.
     *
     * @param context    The context in which the adapter is being used.
     * @param resourceId The resource ID for the layout file representing a single item in the list.
     * @param items      The list of ShipmentModel objects to be displayed.
     */
    public ShipmentAdapter(Context context, int resourceId, List<ShipmentModel> items) {
        super(context, resourceId, items);
        this.resourceId = resourceId;
    }



    /**
     * Returns the view for a specific position in the adapter.
     *
     * @param position    The position of the item within the adapter's data set.
     * @param convertView The old view to reuse, if possible.
     * @param parent      The parent ViewGroup for the view.
     * @return The view corresponding to the specified position.
     */
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

        TextView clientName = convertView.findViewById(R.id.customer_name);
        clientName.setText(shipment.getClientModel().getName());

        return convertView;
    }
}
