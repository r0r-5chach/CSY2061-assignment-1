package xyz.r0r5chach.cpsAssist.dice;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import xyz.r0r5chach.cpsAssist.R;

public class DiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        setTitle("Dice Roller- " + getIntent().getStringExtra("username"));
        if (getIntent().hasExtra("background")) {
            findViewById(R.id.dice_layout).setBackgroundColor(Color.parseColor(getIntent().getStringExtra("background")));
        }
        findViewById(R.id.dice_roll_button).setOnClickListener(new BtnOnClickListener());
    }

}
