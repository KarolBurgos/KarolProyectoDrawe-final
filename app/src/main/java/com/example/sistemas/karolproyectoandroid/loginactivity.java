package com.example.sistemas.karolproyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginactivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView Info;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        name =(EditText)findViewById(R.id.editText4);
        password =(EditText)findViewById(R.id.editText5);
        login =(Button)findViewById(R.id.ingresar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }


    private void validate(String username,String passw)
    {
        if((username.equals("admin"))&&(passw.equals("1234")))
        {
            Intent intent= new Intent(loginactivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }
}
