package xyz.r0r5chach.cpsAssist.dice;


import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import xyz.r0r5chach.cpsAssist.R;

public class BtnOnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        LinearLayout l = (LinearLayout) v.getParent();
        Random rand = new Random();
        TextView output = l.findViewById(R.id.dice_output);
        EditText input = l.findViewById(R.id.dice_input);
        output.setText(String.valueOf(rand.nextInt(Integer.parseInt(input.getText().toString()))));
    }
}
