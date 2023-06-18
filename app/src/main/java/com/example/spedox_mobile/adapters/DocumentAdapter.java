package com.example.spedox_mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.spedox_mobile.R;
import com.example.spedox_mobile.models.DocumentModel;

import java.util.List;

/**

 ArrayAdapter subclass for displaying DocumentModel objects in a ListView.
 Provides custom views for each item in the list.
 */
public class DocumentAdapter extends ArrayAdapter<DocumentModel> {
    private int resourceId;

    /**
     * Constructs a new DocumentAdapter.
     *
     * @param context    The context in which the adapter is being used.
     * @param resourceId The resource ID for the layout file representing a single item in the list.
     * @param items      The list of DocumentModel objects to be displayed.
     */
    public DocumentAdapter(Context context, int resourceId, List<DocumentModel> items) {
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
        DocumentModel document = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(this.resourceId, parent, false);
        }

        TextView fileNameTextView = convertView.findViewById(R.id.file_name);
        TextView fileStatusTextView = convertView.findViewById(R.id.file_status);
        TextView documentType = convertView.findViewById(R.id.document_type);

        fileNameTextView.setText(document.getFileName());
        fileStatusTextView.setText(document.getDocumentStatus().getStatus().toString());
        documentType.setText(document.getDocumentType().getValue().toString());

        return convertView;
    }
}
