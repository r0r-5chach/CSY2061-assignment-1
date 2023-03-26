package xyz.r0r5chach.cpsAssist.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.stream.IntStream;

import xyz.r0r5chach.cpsAssist.R;

public class QuizActivity extends AppCompatActivity {
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setTitle("Quiz- " + getIntent().getStringExtra("username"));
        LinearLayout layout = findViewById(R.id.quiz_layout);
        quiz = new Quiz(getString(R.string.questions), getString(R.string.correct_answers), getString(R.string.incorrect_answers));
        initQuestions(layout);
        initSubmit(layout);
    }

    private void initSubmit(LinearLayout l) {
        Button button = new Button(this);
        button.setText(R.string.submit_button_text);
        button.setOnClickListener(new BtnOnClickListener(quiz.getCorrectAnswers()));
        l.addView(button);
    }


    private void initQuestions(LinearLayout l) {
        IntStream.range(0, quiz.getQuestions().length).forEach(i -> {
            RadioGroup questionGroup = new RadioGroup(this);
            int id = getId(i);
            questionGroup.setId(id);
            TextView question = new TextView(this);
            question.setText(quiz.getQuestions()[i]);
            questionGroup.addView(question);
            for (String answer : quiz.getAnswers().get(i)) {
                RadioButton answerButton = new RadioButton(this);
                answerButton.setText(answer);
                questionGroup.addView(answerButton);
            }
            l.addView(questionGroup);
        });
    }

    private int getId(int index) {
        int id;
        switch(index) {
            case 0:
                id = R.id.question1;
                break;
            case 1:
                id = R.id.question2;
                break;
            case 2:
                id = R.id.question3;
                break;
            case 3:
                id = R.id.question4;
                break;
            case 4:
                id = R.id.question5;
                break;
            default:
                id = 0;
        }
        return id;
    }
}
