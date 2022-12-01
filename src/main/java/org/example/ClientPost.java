package org.example;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClientPost {
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:80/de");
        httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
        JSONObject json = new JSONObject();
        json.put("name","aa");
        json.put("age",22);
        StringEntity se = new StringEntity(json.toString());
        httpPost.setEntity(se);
        CloseableHttpResponse response = null;
        try {
            response = aDefault.execute(httpPost);
            HttpEntity entity = response.getEntity();
            Header[] allHeaders = response.getAllHeaders();
            System.out.println("head " + Arrays.toString(allHeaders));
            String s = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(s);
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
