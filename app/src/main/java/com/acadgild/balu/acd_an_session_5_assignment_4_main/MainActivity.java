package com.acadgild.balu.acd_an_session_5_assignment_4_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText et_user, et_email, et_password;
    Button btn_login;
    TextView tv_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = (EditText) findViewById(R.id.editText_user);
        et_email = (EditText) findViewById(R.id.editText_email);
        et_password = (EditText) findViewById(R.id.editText_password);
        btn_login = (Button) findViewById(R.id.button_login);
        tv_signup = (TextView) findViewById(R.id.textView_signup);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (TextUtils.isEmpty(et_user.getText().toString()))
        {
            et_user.setError(getResources().getString(R.string.blank_user));
            Toast.makeText(this, getResources().getString(R.string.blank_user), Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(et_email.getText().toString()))
        {
            et_email.setError(getResources().getString(R.string.blank_email));
            Toast.makeText(this, getResources().getString(R.string.blank_email), Toast.LENGTH_LONG).show();
        }
        else if (!(Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches()))
        {
            et_email.setError(getResources().getString(R.string.invalid_email));
            Toast.makeText(this, getResources().getString(R.string.invalid_email),Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(et_password.getText().toString()))
        {
            et_password.setError(getResources().getString(R.string.blank_password));
            Toast.makeText(this, getResources().getString(R.string.blank_password), Toast.LENGTH_LONG).show();
        }
        else
        {
            String string_welcome = String.format(getResources().getString(R.string.welcome_user),
                                                  et_user.getText().toString());
            Intent intent_login = new Intent(getApplicationContext(), Welcome.class);

            Bundle bundle_login = new Bundle();
            bundle_login.putString("WELCOME", string_welcome);
            intent_login.putExtras(bundle_login);

            startActivity(intent_login);
        }
    }
}
