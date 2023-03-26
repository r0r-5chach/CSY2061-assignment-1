package xyz.r0r5chach.cpsAssist.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Locale;
import java.util.Random;

import xyz.r0r5chach.cpsAssist.BtnID;
import xyz.r0r5chach.cpsAssist.dice.DiceActivity;
import xyz.r0r5chach.cpsAssist.R;
import xyz.r0r5chach.cpsAssist.quiz.QuizActivity;
import xyz.r0r5chach.cpsAssist.notes.NotesActivity;

public class BtnOnClickListener implements View.OnClickListener{
    private String backgroundColor;

    public BtnOnClickListener() {
        backgroundColor = null;
    }

    @Override
    public void onClick(View v) {
        LinearLayout l = (LinearLayout) v.getParent();
        String id = v.getResources().getResourceName(v.getId()).split("/")[1];
        Intent intent = null;
        switch(BtnID.valueOf(id.toUpperCase(Locale.ROOT))) {
            case NOTES_BUTTON:
                intent = new Intent(v.getContext(), NotesActivity.class);
                break;
            case QUIZ_BUTTON:
                intent = new Intent(v.getContext(), QuizActivity.class);
                break;
            case DICE_BUTTON:
                intent = new Intent(v.getContext(), DiceActivity.class);
                break;
            case BACKGROUND_BUTTON:
                Random rand = new Random();
                backgroundColor = String.format("#%06x", rand.nextInt(0xffffff + 1));
                l.setBackgroundColor(Color.parseColor(backgroundColor));
                break;
        }
        Activity main = (Activity) v.getContext();
        if (intent != null) {
            intent.putExtra("username", main.getIntent().getStringExtra("username"));
            if (backgroundColor != null) {
                intent.putExtra("background", backgroundColor);
            }
            main.startActivity(intent);
        }
    }
}
