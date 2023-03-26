package xyz.r0r5chach.cpsAssist.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import xyz.r0r5chach.cpsAssist.R;

/**
 * This Class defines the processes to run for the login activity for the application
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * This method defines what to do when the activity is created
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.loginButton).setOnClickListener(new BtnOnClickListener(findViewById(R.id.userNameField), findViewById(R.id.passwordField), getString(R.string.users)));
    }
}