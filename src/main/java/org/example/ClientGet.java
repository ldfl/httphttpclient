package org.example;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClientGet {
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/MavenWebappTcomcat_war_exploded/a?name=haha");
        RequestConfig build = RequestConfig.custom().setConnectionRequestTimeout(2).build();
        httpGet.setConfig(build);
        CloseableHttpResponse response = null;
        try {
            response = aDefault.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(s); // liude+f ang
            // 关闭资源
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (aDefault != null) {
                try {
                    aDefault.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
