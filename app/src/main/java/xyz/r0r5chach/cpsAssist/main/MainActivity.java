package xyz.r0r5chach.cpsAssist.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import xyz.r0r5chach.cpsAssist.R;
import xyz.r0r5chach.cpsAssist.main.BtnOnClickListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home- " + getIntent().getStringExtra("username"));
        findViewById(R.id.notes_button).setOnClickListener(new BtnOnClickListener());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
