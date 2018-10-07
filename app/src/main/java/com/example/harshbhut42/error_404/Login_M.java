package com.example.harshbhut42.error_404;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_M extends AppCompatActivity {

    private TextView mPersion;
    private String mTemp;
    private Button mLogin;
    private Button mRegistor;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    private ProgressDialog mLoginProgress;

    private android.support.v7.widget.Toolbar mToolbar;

    ///Firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__m);

        Bundle extra = getIntent().getExtras();

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.activity_login_m_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Login");


        mPersion = (TextView) findViewById(R.id.activity_login_m_persion);
        mTemp = extra.getString("name");
        mPersion.setText(mTemp + " login");

        mLoginProgress = new ProgressDialog(this);

        mLogin = (Button) findViewById(R.id.activity_login_m_login);
        mRegistor = (Button) findViewById(R.id.activity_login_m_register);

        mEmail = (TextInputLayout) findViewById(R.id.activity_login_m_email);
        mPassword = (TextInputLayout) findViewById(R.id.activity_login_m_password);

        mAuth = FirebaseAuth.getInstance();

        mRegistor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_M.this,RegisterActivity.class);
                intent.putExtra("nameR",mTemp);
                startActivity(intent);
            }
        });


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();

                if(email.equals("") || password.equals(""))
                {
                    Toast.makeText(Login_M.this,"Enter email and password",Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("parent") && mTemp.equals("Parent"))
                {
                    Toast.makeText(Login_M.this,"Enter valid email",Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("prof") && mTemp.equals("Professer"))
                {
                    Toast.makeText(Login_M.this,"Enter valid email",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mLoginProgress.setTitle("Logging");
                    mLoginProgress.setMessage("Please wait...");
                    mLoginProgress.setCanceledOnTouchOutside(false);
                    mLoginProgress.show();

                    login(email,password);
                }

            }
        });


    }

    private void login(final String email, String password) {

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    mLoginProgress.dismiss();

                    if(email.contains("prof"))
                    {
                        Intent main_intent = new Intent(Login_M.this,MainActivity_M.class);
                        main_intent.putExtra("Email",email);
                        startActivity(main_intent);
                    }
                    else if(email.contains("parent"))
                    {
                        Intent main_intent = new Intent(Login_M.this,parent_button.class);
                        main_intent.putExtra("Email",email);
                        startActivity(main_intent);
                    }
                    else {
                        Intent main_intent = new Intent(Login_M.this,Student.class);
                        main_intent.putExtra("Email",email);
                        startActivity(main_intent);
                    }


                    finish();
                }
                else
                {
                    mLoginProgress.hide();
                    Toast.makeText(Login_M.this,"Enter correct email and password",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
