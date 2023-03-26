package xyz.r0r5chach.cpsAssist.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import xyz.r0r5chach.cpsAssist.R;

public class NotesActivity extends AppCompatActivity {
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initRecycler();
        setTitle("Notes- " + getIntent().getStringExtra("username"));
        if (getIntent().hasExtra("background")) {
            findViewById(R.id.notes_layout).setBackgroundColor(Color.parseColor(getIntent().getStringExtra("background")));
        }
        findViewById(R.id.add_Button).setOnClickListener(new BtnOnClickListener(adapter));
    }

    private void initRecycler() {
        RecyclerView list = findViewById(R.id.notesList);
        adapter = new Adapter(getExternalFilesDir(null), getIntent().getStringExtra("username"));
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyItemRangeChanged(0, adapter.getItemCount());
    }
}