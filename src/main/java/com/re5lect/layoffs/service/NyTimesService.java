package com.re5lect.layoffs.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

@Service
public class NyTimesService {
    private static final String API_KEY= "";
    private static final String API_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=tech+company+layoffs&api-key=" + API_KEY;

    public String fetchNewsData() {
        try(CloseableHttpClient httpClient= HttpClients.createDefault()){
            HttpGet request= new HttpGet(API_URL);
            HttpResponse response= httpClient.execute(request);
//            entity content actual content of the http
            HttpEntity entity= response.getEntity();

            if(entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
