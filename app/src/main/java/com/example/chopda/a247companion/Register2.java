package com.example.chopda.a247companion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register2 extends AppCompatActivity {

    EditText e_first, e_last, e_mail, e_contact, e_password;
    String first, last, mail, contact,  password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        e_first= (EditText)findViewById(R.id.first);
        e_last= (EditText)findViewById(R.id.last);
        e_mail= (EditText)findViewById(R.id.email);
        e_contact= (EditText) findViewById(R.id.contact);
        e_password= (EditText)findViewById(R.id.password);

    }

    public void rgUser(View view){
        first= e_first.getText().toString();
        last= e_last.getText().toString();
        mail= e_mail.getText().toString();
        contact= e_contact.getText().toString();
        password= e_password.getText().toString();

        String method= "Register";
        BackgroundTask background= new BackgroundTask(this);
        background.execute(method, first, last, mail, contact, password);

        finish();
    }
}
