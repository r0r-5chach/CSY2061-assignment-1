package xyz.r0r5chach.cpsAssist.notes;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;

import xyz.r0r5chach.cpsAssist.R;


public class BtnOnClickListener implements View.OnClickListener {
    private final Adapter adapter;

    public BtnOnClickListener(Adapter adapter) {
        this.adapter = adapter;
    }


    @Override
    public void onClick(View view) {
        String path;
        String id = view.getResources().getResourceName(view.getId()).split("/")[1];
        switch(BtnID.valueOf(id.toUpperCase(Locale.ROOT))) {
            case ADD_BUTTON:
                onAddClick();
                Toast.makeText(view.getContext(), "File Created", Toast.LENGTH_LONG).show();
                break;
            case EDIT_BUTTON:
                path = getPath(view);
                onEditClick(path, view);
                break;
            case DELETE_BUTTON:
                path = getPath(view);
                onDeleteClick(path);
                Toast.makeText(view.getContext(), "File Deleted" , Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void onAddClick() {
        adapter.getNotes().createNote();
        adapter.notifyItemInserted(adapter.getNotes().getAmount());
    }

    private void onEditClick(String path, View v) {
        File tmp = new File(v.getContext().getExternalFilesDir(null) + "/" + path); //load file into var
        FileReader r = null;
        AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
        dialog.setTitle("Edit Note");
        dialog.setView(R.layout.edit_dialog);
        dialog.create().show();
        //TODO: get text from dialog and save to file
        //TODO: set text in dialog to what is in note
        adapter.getNotes().updateNote(tmp, "");
        adapter.notifyItemChanged(adapter.getNotes().getNoteIndex(tmp));
    }

    private void onDeleteClick(String path) {
        adapter.notifyItemRemoved(adapter.getNotes().deleteNote(path));
    }

    private String getPath(View v) {
        LinearLayout row = (LinearLayout) v.getParent();
        TextView name = row.findViewById(R.id.fileNameField);
        return name.getText().toString();
    }

}