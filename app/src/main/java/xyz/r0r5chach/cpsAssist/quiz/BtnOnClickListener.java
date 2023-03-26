package xyz.r0r5chach.cpsAssist.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import xyz.r0r5chach.cpsAssist.R;

public class BtnOnClickListener implements View.OnClickListener{
    private final String[] correctAnswers;


    public BtnOnClickListener(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public void onClick(View v) {
        LinearLayout l = (LinearLayout) v.getParent();
        RadioGroup[] questions = new RadioGroup[]{l.findViewById(R.id.question1), l.findViewById(R.id.question2), l.findViewById(R.id.question3), l.findViewById(R.id.question4), l.findViewById(R.id.question5)};
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getCheckedRadioButtonId() == -1) {
                continue;
            }
            RadioButton answer = questions[i].findViewById(questions[i].getCheckedRadioButtonId());
            if (answer.getText().toString().equals(correctAnswers[i])) {
                score++;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Results");
        builder.setMessage(score + "/5");
        builder.setPositiveButton("Save", new DialogOnClickListener(((Activity)v.getContext()).getIntent().getStringExtra("username"), score));
        builder.setNeutralButton("Ok", new DialogOnClickListener());
        builder.create().show();
    }
}
