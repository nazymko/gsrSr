package com.company.api_sender;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static com.company.utils.IOutil.convertStreamToString;

/**
 * Created by nazymko.patronus@gmail.com
 */
public class DefaultSender {


    public void send(String data, boolean send) throws IOException {
        if (send) {
            String encodedData = URLEncoder.encode(data, "UTF-8");
            URL u = new URL("http://krok-test.vn.ua/api/add");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(encodedData.length()));
            conn.setRequestProperty("Authorization", "Basic YWRtaW4xQHRlc3QuaW86NTE4U3NkMyMy");
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes("UTF-8"));
            os.flush();
            System.out.println(conn.getRequestMethod());
            System.out.println(conn.getResponseMessage());
            InputStream stream = conn.getInputStream();
            String result = convertStreamToString(stream);
            System.out.println("result = " + result);
        }
    }

}
