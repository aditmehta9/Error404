package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity_M extends AppCompatActivity {

    private Button mGroupChat,mGroupEmail,mEmail,mSendGrade;

    private android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__m);


        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.activity_main_m_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Error404");


        mGroupChat = (Button) findViewById(R.id.activity_main_m_groupChat);
        mGroupEmail = (Button) findViewById(R.id.activity_main_m_groupEmail);
        mEmail = (Button) findViewById(R.id.activity_main_m_email);
        mSendGrade = (Button) findViewById(R.id.activity_main_m_sendGrade);

        mGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mGroupEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_M.this,Notice.class);
                startActivity(intent);
            }
        });

        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_M.this,particular_student_email.class);
                startActivity(intent);
            }
        });

        mSendGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_M.this,send_grade.class);
                startActivity(intent);
            }
        });


    }

    private void updateUI() {

        Intent intent = new Intent(MainActivity_M.this,CategoryActivity.class);
        startActivity(intent);

        finish();  //    user can not come back if he is not login using press back
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu);   // set menu like XML file in onCreate method

        return true;           // always return true
    }

    // caled when item of menu bar seleced
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);


        if(item.getItemId() == R.id.main_menu_logout)
        {
            FirebaseAuth.getInstance().signOut();  // user will log out but we need to change UI
            updateUI();
        }

        return true;
    }



}
