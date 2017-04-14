package com.company;

import com.company.api_sender.DefaultSender;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        testIt();
    }

    public static void testIt() throws IOException {
        String string = "{\n" +
                "  \"test\": \"Гематологія №1\",\n" +
                "  \"description\": \"test_description\",\n" +
                "  \"questions\": [\n" +
                "    {\n" +
                "      \"question\": \"question_1\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"question_1_answer1\": true,\n" +
                "          \"question_1_answer2\": false,\n" +
                "          \"question_1_answer3\": false,\n" +
                "          \"question_1_answer4\": false\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"question_2\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"question_2_answer1\": true,\n" +
                "          \"question_2_answer2\": false,\n" +
                "          \"question_2_answer3\": false,\n" +
                "          \"question_2_answer4\": false\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        com.company.test_model.Test test = new Gson().fromJson(string, com.company.test_model.Test.class);

        System.out.println("test = " + test);

        String json = new Gson().toJson(test);


        new DefaultSender().send(json);


    }

}
