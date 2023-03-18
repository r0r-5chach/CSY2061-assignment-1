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

    private final List<File> notes;

    public Adapter(List<File> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        File note = notes.get(index);
        holder.getFileName().setText(note.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
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
