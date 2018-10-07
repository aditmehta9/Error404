package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Student extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mChats,mMaterials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final Bundle extra = getIntent().getExtras();

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.activity_student_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Error404");

        mChats = (Button) findViewById(R.id.activity_student_Chats);
        mMaterials = (Button) findViewById(R.id.activity_student_Materials);
        mToolbar = (Toolbar) findViewById(R.id.activity_student_toolbar);


        mChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Student.this,StudentChat.class);
                intent.putExtra("email",extra.getString("Email"));
                startActivity(intent);

            }
        });


        mMaterials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Student.this,WebView.class);
                startActivity(intent);

            }
        });

    }


    private void updateUI() {

        Intent intent = new Intent(Student.this,CategoryActivity.class);
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
