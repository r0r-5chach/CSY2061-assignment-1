package xyz.r0r5chach.cpsAssist.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.io.File;

import xyz.r0r5chach.cpsAssist.notes.Notes;

public class DialogOnClickListener implements DialogInterface.OnClickListener {
    private String username;
    private int score;


    public DialogOnClickListener() {

    }

    public DialogOnClickListener(String username, int score) {
        this.score = score;
        this.username = username;
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        AlertDialog d = (AlertDialog) dialog;
        if (which == DialogInterface.BUTTON_POSITIVE) {
            Notes notes = new Notes(d.getContext().getExternalFilesDir(null), username);
            notes.createNote();
            File note = notes.getNote(notes.getAmount()-1);
            notes.updateNote(note, "Quiz Results: " + score + "/5");
        }
        d.dismiss();
    }
}
