package com.acadgild.balu.acd_an_session_5_assignment_4_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView tv_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv_welcome = (TextView) findViewById(R.id.textView_welcome);

        Bundle bundle_login = getIntent().getExtras();
        tv_welcome.setText(bundle_login.getString("WELCOME"));

    }
}
