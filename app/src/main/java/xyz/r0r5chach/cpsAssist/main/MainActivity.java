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
        initButtons();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void initButtons() {
        findViewById(R.id.notes_button).setOnClickListener(new BtnOnClickListener());
        findViewById(R.id.quiz_button).setOnClickListener(new BtnOnClickListener());
    }
}
