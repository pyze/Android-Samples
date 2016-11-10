package com.pyze.samples.eventsampleandroid.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pyze.android.Pyze;
import com.pyze.android.constants.Constants;
import com.pyze.android.inapp.templates.ui.InAppNotificationTemplateDialogFragment;
import com.pyze.samples.eventsampleandroid.R;

public class PyzeEventHomeActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyze_event_home_activty);
        findViewById(R.id.event_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PyzeEventHomeActivty.this, EventClassActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.about_pyze_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://pyze.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        findViewById(R.id.show_unread_message_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pyze.showInAppNotificationUI(PyzeEventHomeActivty.this, new InAppNotificationTemplateDialogFragment.OnButtonClickListener() {
                    @Override
                    public void onButtonClicked(Pyze.InAppStatus inAppStatus) {
                        Toast.makeText(PyzeEventHomeActivty.this,"In App Button Clicked!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        findViewById(R.id.show_all_messages_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pyze.showInAppNotificationUI(PyzeEventHomeActivty.this, Constants.PyzeInAppMessageType.PyzeInAppTypeAll, "#C9C9C9 ", new InAppNotificationTemplateDialogFragment.OnButtonClickListener() {
                    @Override
                    public void onButtonClicked(Pyze.InAppStatus inAppStatus) {
                        Toast.makeText(PyzeEventHomeActivty.this,"In App Button Clicked!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
