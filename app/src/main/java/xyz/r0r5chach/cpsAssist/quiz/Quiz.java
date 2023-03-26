package xyz.r0r5chach.cpsAssist.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    private final String[] questions;

    private String[] correctAnswers;

    private final List<List<String>> answers;

    private final String storedCorrectAnswers;
    private final String storedIncorrectAnswers;

    public Quiz(String storedQuestions, String storedCorrectAnswers, String storedIncorrectAnswers) {
        questions = parseList(storedQuestions);
        answers = new ArrayList<>();
        this.storedCorrectAnswers = storedCorrectAnswers;
        this.storedIncorrectAnswers = storedIncorrectAnswers;
        parseAnswers();

    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    public String[] getQuestions() {
        return questions;
    }

    public List<List<String>> getAnswers() {
        return answers;
    }

    private void parseAnswers() {
        correctAnswers = parseList(storedCorrectAnswers);
        String[] incorrectAnswers = parseList(storedIncorrectAnswers);
        for (int i = 0; i < incorrectAnswers.length; i++) {
            List<String> answers = new ArrayList<>();
            answers.add(correctAnswers[i]);
            answers.addAll(Arrays.asList(incorrectAnswers[i].split("%")));
            this.answers.add(answers);
        }
    }


    private String[] parseList(String list) {
        return list.split("#");
    }
}
