package com.company.formats;

import com.company.test_model.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nazymko.patronus@gmail.com
 */
public class Test1Format implements FormatReader {

    List<String> markers = Arrays.asList(
            "а)",
            "б)",
            "г)",
            "д)",
            "в)",
            "а ",
            "б ",
            "г ",
            "д ",
            "в "
    );

    @Override
    public Test read(String content, String testName) {
        content = removeEmptyLines(content);

        System.out.println(content);

        String[] split = content.split("\n");
        Test test = new Test(testName, testName);
        Test.Question question = null;
        for (String line : split) {
            if (isAnswer(line)) {
                line = removeMark(line);
                if (question != null) {
                    boolean isCorrect = false;
                    if (line.contains("( + )")) {
                        line = line.replace("( + )", "");
                        isCorrect = true;
                    }
                    if (line.contains("(+)")) {
                        line = line.replace("(+)", "");
                        isCorrect = true;
                    }
                    if (line.contains("+")) {
                        line = line.replace("+", "");
                        isCorrect = true;
                    }
                    line = line.trim();
                    if (line.startsWith(".")) {
                        line = line.substring(1);
                    }
                    question.getAnswers().put(line, isCorrect);
                }
            } else {
                question = new Test.Question(line.trim());
                test.getQuestions().add(question);
            }

        }

        return test;
    }

    private String removeMark(String s) {
        return s.substring(2).trim();
    }

    private boolean isAnswer(String s) {
        for (String marker : markers) {
            if ((s.trim().startsWith(marker))) {
                return true;
            }
        }
        return false;
    }

    private String removeEmptyLines(String content) {
        String[] split = content.split("\n");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            if (s != null && !s.trim().isEmpty()) {
                builder.append(s).append("\n");
            }
        }
        content = builder.toString();
        return content;
    }
}
