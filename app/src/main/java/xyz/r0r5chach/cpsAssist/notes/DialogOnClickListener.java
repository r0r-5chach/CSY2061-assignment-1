package xyz.r0r5chach.cpsAssist.notes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;

import java.io.File;

import xyz.r0r5chach.cpsAssist.R;

public class DialogOnClickListener implements DialogInterface.OnClickListener {
    private Adapter adapter;
    private File note;
    private TextView editField;


    public DialogOnClickListener() {

    }

    public DialogOnClickListener(Adapter adapter, File note, TextView editField) {
        this.adapter = adapter;
        this.note = note;
        this.editField = editField;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        AlertDialog d = (AlertDialog) dialog;
        if (which == DialogInterface.BUTTON_POSITIVE) {
            adapter.getNotes().updateNote(note, editField.getText().toString());
            adapter.notifyItemChanged(adapter.getNotes().getNoteIndex(note));
        }
        d.dismiss();
    }
}
