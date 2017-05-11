package com.example.wadeowen.usersignup;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by WadeOwen on 09-May-17.
 */

public class SignUpActivity extends AppCompatActivity {


    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersignup);

        editName = (EditText) findViewById(R.id.name);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);




    }


    public void signUp(){

        String pass =editPassword.getText().toString();
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();


        if(isPasswordValid(pass) && isEmailValid(email) && isNameValid(name)){
            new AlertDialog.Builder(SignUpActivity.this).setTitle("Message").setMessage("Usuario Creado Exitosamente.").show();
        }
    }

    public boolean isPasswordValid(String pass){

        return pass.length() > 6 && pass.matches(".*\\d+.*");
    }

    public boolean isEmailValid(String email){

        return email.length() > 6 && email.contains("@");
    }

    public boolean isNameValid(String name){

        return name.length() > 4;
    }

    public class EditTextListener implements TextView.OnEditorActionListener {


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                signUp();
            }

            return false;
        }
    }
}
