package com.example.harshbhut42.error_404;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentChat extends AppCompatActivity {

    private FirebaseListAdapter<ChatMessage_Modual> adapter;
    private ListView listView;
    private String loggedInUserName = "";

    private DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chat);

        final Bundle extra = getIntent().getExtras();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.activity_student_chat_send);
        final EditText input = (EditText) findViewById(R.id.activity_student_chat_message);
        listView = (ListView) findViewById(R.id.activity_student_chat_list);
        showAllOldMessages();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().trim().equals("")) {
                    Toast.makeText(StudentChat.this, "Please enter some texts!", Toast.LENGTH_SHORT).show();
                } else {
                    mRef = FirebaseDatabase.getInstance().getReference().child("Chats").push();
                    mRef.setValue(new ChatMessage_Modual(input.getText().toString(),
                            extra.getString("email"),
                            FirebaseAuth.getInstance().getCurrentUser().getUid()));



                  /*  mRef.child("messageText").setValue(input.getText().toString());
                    mRef.child("messageTime").setValue(new Date().getTime());
                    mRef.child("messageUser").setValue( FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
                    mRef.child("messageUserId").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
*/

                    input.setText("");
                }
            }
        });

    }

    private void showAllOldMessages() {
        loggedInUserName = FirebaseAuth.getInstance().getCurrentUser().getUid();


        adapter = new MessageAdapter(this, ChatMessage_Modual.class, R.layout.send_message,
                FirebaseDatabase.getInstance().getReference());
        listView.setAdapter(adapter);
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }


}
