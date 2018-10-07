package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class parent_button extends AppCompatActivity {
Button chatbutton,appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_button);
        final Bundle extra = getIntent().getExtras();
        chatbutton = findViewById(R.id.parent_button_chat);
        appointment = findViewById(R.id.parent_button_appointment);
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent_button.this,StudentChat.class);
                intent.putExtra("email",extra.getString("Email"));
                startActivity(intent);
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_intent = new Intent(parent_button.this,list_view_appointment.class);
                startActivity(main_intent);
            }
        });
    }
}
