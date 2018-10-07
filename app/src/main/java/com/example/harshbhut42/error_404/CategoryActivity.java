package com.example.harshbhut42.error_404;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {


    private Button mParent,mStudent,mProfesser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        mProfesser = (Button) findViewById(R.id.activity_category_professer);
        mStudent = (Button) findViewById(R.id.activity_category_student);
        mParent = (Button) findViewById(R.id.activity_category_parent);


        mProfesser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,Login_M.class);

                intent.putExtra("name","Professer");
                startActivity(intent);

            }
        });

        mStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,Login_M.class);

                intent.putExtra("name","Student");
                startActivity(intent);


            }
        });

        mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,Login_M.class);

                intent.putExtra("name","Parent");
                startActivity(intent);


            }
        });


    }
}
