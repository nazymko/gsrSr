package com.company.test_model;

import java.util.*;

/**
 * Created by nazymko.patronus@gmail.com
 */
public class Test {
    String test;
    String description;
    List<Question> questions;

    public Test(String testName, String description) {
        this.test = testName;
        this.description = description;
        this.questions = new LinkedList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public static class Question {
        String question;
        List<Map<String, Boolean>> answers;

        public Question(String question) {
            this.question = question;
            this.answers = new ArrayList<Map<String, Boolean>>() {{
                add(new HashMap<String, Boolean>());
            }};

        }

        public Map<String, Boolean> getAnswers() {
            return answers.get(0);
        }
    }

}
