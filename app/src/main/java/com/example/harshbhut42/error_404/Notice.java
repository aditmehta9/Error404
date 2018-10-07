package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notice extends AppCompatActivity {

    EditText subject,body;
    String subjectstring,bodystring;
    Button sendbutton;
    String[] to=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


        sendbutton = findViewById(R.id.activity_notice_send);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));


                subject = findViewById(R.id.activity_notice_subject);
                body = findViewById(R.id.activity_notice_body);


                subjectstring = subject.getText().toString();
                bodystring = body.getText().toString();

                String[] to1 = new String[10] ;
                for(int i=0;i<10;i+=2) {
                    int x = 201701000+i;
                    String emailid = Integer.toString(x)+"@daiict.ac.in";
                    to1[i] = "parent"+emailid;
                    to1[i+1] = emailid;
                }
                intent.putExtra(Intent.EXTRA_EMAIL, "aditmehta9@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, subjectstring);
                intent.putExtra(Intent.EXTRA_CC,to1);
                intent.putExtra(Intent.EXTRA_TEXT, bodystring);
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);
            }
        });
    }
}
