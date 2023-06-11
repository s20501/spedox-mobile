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

public class DocumentAdapter extends ArrayAdapter<DocumentModel> {
    private int resourceId;

    public DocumentAdapter(Context context, int resourceId, List<DocumentModel> items) {
        super(context, resourceId, items);
        this.resourceId = resourceId;
    }

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
