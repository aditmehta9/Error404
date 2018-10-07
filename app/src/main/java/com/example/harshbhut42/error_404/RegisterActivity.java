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
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mEmail;
    private TextInputLayout mPassword;
    private Button mCreatAcount;
    private String mTemp;
    private ProgressDialog mRegisterProgress;  // progress dilog
    private android.support.v7.widget.Toolbar mToolbar;
    private TextView mPersion;
    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle extra = getIntent().getExtras();

        mTemp = extra.getString("nameR");

        mEmail = (TextInputLayout) findViewById(R.id.activity_register_email);
        mPassword = (TextInputLayout) findViewById(R.id.activity_register_password);

        mPersion = (TextView) findViewById(R.id.activity_register_persion);
        mPersion.setText(mTemp);

        mCreatAcount = (Button) findViewById(R.id.activity_register_creatAcount);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.activity_register_toolbar);
        setSupportActionBar(mToolbar);                     // set toolbar as action bar
        getSupportActionBar().setTitle("Create Acount");       // set title of action bar(toolbar)
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // wii show arrow(<-) in action bar when we press it will take as on parent activity

        mRegisterProgress = new ProgressDialog(this);

        //Firebase
        mAuth = FirebaseAuth.getInstance();


        mCreatAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = mEmail.getEditText().getText().toString();
                String Password = mPassword.getEditText().getText().toString();

                if(Email.equals("") || Password.equals("")){
                    Toast.makeText(RegisterActivity.this,"Enter all information",Toast.LENGTH_SHORT).show();
                }
                else if(!Email.contains("parent") && mTemp.equals("Parent")) {
                    Toast.makeText(RegisterActivity.this,"Enter /////valid email",Toast.LENGTH_SHORT).show();
                }
                else if(!Email.contains("prof") && mTemp.equals("Professer")) {
                    Toast.makeText(RegisterActivity.this,"Enter valid email",Toast.LENGTH_SHORT).show();

                }
                else {
                    mRegisterProgress.setTitle("Registering");
                    mRegisterProgress.setMessage("Please wait...");
                    mRegisterProgress.setCanceledOnTouchOutside(false);
                    mRegisterProgress.show();

                    register_User(Email,Password);
                }


            }
        });



    }

    private void register_User(final String email, String password) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {

                    mRegisterProgress.dismiss();
                    if(email.contains("prof"))
                    {
                       /* FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                        String uid = currentUser.getUid();

                        mRef = FirebaseDatabase.getInstance().getReference().child("Email").child(uid);
*/
                        Intent main_intent = new Intent(RegisterActivity.this,MainActivity_M.class);

                        main_intent.putExtra("Email",email);

                        startActivity(main_intent);
                    }
                    else if(email.contains("parent"))
                    {
                        Intent main_intent = new Intent(RegisterActivity.this,parent_button.class);
                        main_intent.putExtra("Email",email);
                        startActivity(main_intent);
                    }
                    else {

                        Intent main_intent = new Intent(RegisterActivity.this,Student.class);
                        main_intent.putExtra("Email",email);
                        startActivity(main_intent);
                    }


                    finish();
                }
                else
                {
                    mRegisterProgress.hide();
                    Toast.makeText(RegisterActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}