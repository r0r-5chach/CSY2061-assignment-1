package xyz.r0r5chach.cpsAssist.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

import xyz.r0r5chach.cpsAssist.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final Notes notes;

    public Adapter(File path, String username) {
        notes = getStoredNotes(path, username);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item, parent, false);
        return new ViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        File note = notes.getNote(index);
        holder.getFileName().setText(note.getName());
    }

    @Override
    public int getItemCount() {
        return notes.getAmount();
    }

    public Notes getNotes() {
        return notes;
    }

    private Notes getStoredNotes(File path, String username) {
        return new Notes(path, username);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fileName;
        private final Button editButton;
        private final Button deleteButton;
        public ViewHolder(View v, Adapter adapter) {
            super(v);
            fileName = v.findViewById(R.id.fileNameField);
            editButton = v.findViewById(R.id.edit_Button);
            deleteButton = v.findViewById(R.id.delete_Button);
            editButton.setOnClickListener(new BtnOnClickListener(adapter));
            deleteButton.setOnClickListener(new BtnOnClickListener(adapter));
        }

        public TextView getFileName() {
            return fileName;
        }

        public Button getEditButton() {
            return editButton;
        }

        public Button getDeleteButton() {
            return deleteButton;
        }
    }

}
