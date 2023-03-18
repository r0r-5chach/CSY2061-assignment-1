package xyz.r0r5chach.cpsAssist.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import xyz.r0r5chach.cpsAssist.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.loginButton).setOnClickListener(new OnClickListener(findViewById(R.id.userNameField), findViewById(R.id.passwordField), getString(R.string.users)));
    }
}