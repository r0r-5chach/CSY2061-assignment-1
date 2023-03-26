package xyz.r0r5chach.cpsAssist.dice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import xyz.r0r5chach.cpsAssist.R;
import xyz.r0r5chach.cpsAssist.dice.BtnOnClickListener;

public class DiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        findViewById(R.id.dice_roll_button).setOnClickListener(new BtnOnClickListener());
    }

}
