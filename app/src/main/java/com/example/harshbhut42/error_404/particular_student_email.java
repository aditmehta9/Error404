package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class particular_student_email extends AppCompatActivity {




    private Toolbar mToolbar;
    TextView mTextView;
    EditText rollno;
    String rollnostring;
    Button sendbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_student_email);



        sendbutton = findViewById(R.id.activity_particular_student_email_button);


        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno =(EditText) findViewById(R.id.activity_particular_student_email_rollno);
                mTextView = (TextView) findViewById(R.id.activity_particular_student_email_textView);
                rollnostring = rollno.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));


                int x = 201701000+Integer.parseInt(rollnostring);
                String emailid = Integer.toString(x)+"@daiict.ac.in";
                String to = emailid;
                String[] to1 = new String[2] ;
                to1[0] = "parent"+emailid;
                to1[1] = emailid;
                intent.putExtra(Intent.EXTRA_EMAIL,emailid);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Notice for roll no.: "+Integer.toString(x));
                intent.putExtra(Intent.EXTRA_CC,to1);
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"Send Email");
                startActivity(chooser);
            }
        });
    }
}
