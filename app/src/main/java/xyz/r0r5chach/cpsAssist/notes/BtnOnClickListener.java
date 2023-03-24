package xyz.r0r5chach.cpsAssist.notes;

import android.view.View;

import java.util.Locale;

public class BtnOnClickListener implements View.OnClickListener {
    private final Adapter adapter;


    public BtnOnClickListener(Adapter adapter) {
        this.adapter = adapter;
    }


    @Override
    public void onClick(View view) {

        String test = view.getResources().getResourceName(view.getId()).split("/")[1];
        switch(ButtonID.valueOf(test.toUpperCase(Locale.ROOT))) {
            case ADD_BUTTON:
                onAddClick();
                break;
        }
    }

    private void onAddClick() {
        Notes notes = adapter.getNotes();
        notes.createNote();
        adapter.notifyItemInserted(notes.getAmount());
    }
}
