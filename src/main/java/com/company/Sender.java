package com.company;

import com.company.api_sender.DefaultSender;
import com.company.formats.Test2Format;
import com.company.test_model.Test;
import com.company.utils.IOutil;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nazymko.patronus@gmail.com
 */
public class Sender {

    public static void main(String[] args) throws IOException {
        send("Тести № 14-15 Вади розвитку сечостатевої системи (укр).txt");
    }

    private static void send(String fileName) throws IOException {
        InputStream file = Sender.class.getClass().getResourceAsStream("/" + fileName);
        String content = IOutil.convertStreamToString(file);


        Test test = new Test2Format().read(content, fileName.replace(".txt", ""));


        checkAnswers(test);


        String toJson = new Gson().toJson(test);

        System.out.println("toJson = " + toJson);

        new DefaultSender().send(toJson, true);
    }

    private static void checkAnswers(Test test) {
        for (Test.Question question : test.getQuestions()) {
            for (Boolean isCorrect : question.getAnswers().values()) {
                if (isCorrect) {
                    return;
                }
            }
            System.out.println("No answers for : " + question.getQuestion());

        }
    }
}
