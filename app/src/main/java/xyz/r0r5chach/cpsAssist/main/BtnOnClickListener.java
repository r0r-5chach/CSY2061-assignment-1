package xyz.r0r5chach.cpsAssist.main;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import java.util.Locale;

import xyz.r0r5chach.cpsAssist.BtnID;
import xyz.r0r5chach.cpsAssist.dice.DiceActivity;
import xyz.r0r5chach.cpsAssist.quiz.QuizActivity;
import xyz.r0r5chach.cpsAssist.notes.NotesActivity;

public class BtnOnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
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
        }
        Activity main = (Activity) v.getContext();
        if (intent != null) {
            intent.putExtra("username", main.getIntent().getStringExtra("username"));
            main.startActivity(intent);
        }
    }
}
