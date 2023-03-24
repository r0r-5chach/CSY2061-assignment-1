package xyz.r0r5chach.cpsAssist.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

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
        return new ViewHolder(v);
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
        public ViewHolder(View v) {
            super(v);
            fileName = v.findViewById(R.id.fileNameField);
        }

        public TextView getFileName() {
            return fileName;
        }
    }

}
