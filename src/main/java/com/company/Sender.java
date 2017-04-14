package com.company;

import com.company.api_sender.DefaultSender;
import com.company.formats.Test1Format;
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
        send("Тести №16 Ниркова недостатність (укр).txt","Тести №16 Ниркова недостатність (укр)");
    }

    private static void send(String fileName, String s) throws IOException {
        InputStream file = Sender.class.getClass().getResourceAsStream("/" + fileName);
        String content = IOutil.convertStreamToString(file);


        Test test = new Test2Format().read(content,s);

        String toJson = new Gson().toJson(test);

        System.out.println("toJson = " + toJson);

        new DefaultSender().send(toJson,false);
    }
}
