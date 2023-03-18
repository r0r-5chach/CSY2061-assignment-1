package xyz.r0r5chach.cpsAssist.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import xyz.r0r5chach.cpsAssist.R;

public class NotesActivity extends AppCompatActivity {
    private List<File> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notes = getStoredNotes();
        initRecycler();
    }

    private void initRecycler() {
        RecyclerView list =findViewById(R.id.notesList);
        list.setAdapter(new Adapter(notes));
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<File> getStoredNotes() {
        return Arrays.asList(Objects.requireNonNull(getFilesDir().listFiles()));
    }
}