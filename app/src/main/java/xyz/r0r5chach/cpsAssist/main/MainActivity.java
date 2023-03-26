package xyz.r0r5chach.cpsAssist.main;

import android.media.MediaDrm;
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
    } //TODO: Add change background button to layout and add logic to listner

    private void initButtons() {
        BtnOnClickListener lstn = new BtnOnClickListener();
        findViewById(R.id.notes_button).setOnClickListener(lstn);
        findViewById(R.id.quiz_button).setOnClickListener(lstn);
        findViewById(R.id.background_button).setOnClickListener(lstn);
    }
}
