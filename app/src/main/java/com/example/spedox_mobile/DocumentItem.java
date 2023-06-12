
package com.example.spedox_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/**

 Represents an activity for displaying a single document item.
 Extends the AppCompatActivity class.
 */
public class DocumentItem extends AppCompatActivity {
    /**
     * Called when the activity is created.
     * Initializes the activity and sets the content view to the layout resource file.
     *
     * @param savedInstanceState The saved instance state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_item);
    }
}