package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class send_grade extends AppCompatActivity {

    EditText rollno,grade;
    String gradestring,rollnostring;
    Button sendbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_grade);
        sendbutton = findViewById(R.id.activity_send_grade_button);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = findViewById(R.id.activity_send_grade_rollno);
                grade = findViewById(R.id.activity_send_grade_grade);
                gradestring = grade.getText().toString();
                rollnostring = rollno.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                int x = 201701000+Integer.parseInt(rollnostring);
                String emailid = Integer.toString(x)+"@daiict.ac.in";
                String to = emailid;
                String[] to1 = new String[2] ;
                to1[0] = "parent"+emailid;
                to1[1] = emailid;
                intent.putExtra(Intent.EXTRA_EMAIL,"aditmehta9@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Grade of roll no.: "+Integer.toString(x));
                intent.putExtra(Intent.EXTRA_CC,to1);
                intent.putExtra(Intent.EXTRA_TEXT,"Grade of student "+Integer.toString(x)+" are "+gradestring+".");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"Send Email");
                startActivity(chooser);
            }
        });
    }
}
