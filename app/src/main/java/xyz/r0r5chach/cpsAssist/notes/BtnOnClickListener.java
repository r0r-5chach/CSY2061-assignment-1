package xyz.r0r5chach.cpsAssist.notes;

import android.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

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
        EditText editField = new EditText(v.getContext());
        editField.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        AlertDialog dialog = editDialog(v, tmp, editField);
        initNoteText(editField, tmp);
        dialog.show();
    }

    private void onDeleteClick(String path) {
        adapter.notifyItemRemoved(adapter.getNotes().deleteNote(path));
    }

    private String getPath(View v) {
        LinearLayout row = (LinearLayout) v.getParent();
        TextView name = row.findViewById(R.id.fileNameField);
        return name.getText().toString();
    }

    private AlertDialog editDialog(View v, File note, TextView editField) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Edit Note");
        builder.setView(editField);
        builder.setPositiveButton("Save", new DialogOnClickListener(adapter, note, editField));
        builder.setNegativeButton("Cancel", new DialogOnClickListener());
        return builder.create();
    }

    private AlertDialog viewDialog(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
        dialog.setTitle("View Note");
        dialog.setMessage("note"); //TODO: Get selected file's note
        return dialog.create();
    }

    private void initNoteText(TextView editField, File note) {
        try {
            Scanner r = new Scanner(note);
            StringBuilder text = new StringBuilder();
            while (r.hasNextLine()) {
                text.append(r.nextLine());
            }
            editField.setText(text.toString());
            r.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}