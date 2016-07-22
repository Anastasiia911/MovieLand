package com.nabivach.movieland.service.impl;


import com.nabivach.movieland.entity.Currency;
import com.nabivach.movieland.service.CurrencyService;
import com.nabivach.movieland.util.deserializer.JsonParse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenericCurrencyService implements CurrencyService {

    @Autowired
    private JsonParse jsonReader;

    @Override
    public String getJsonCurrencyFromNBU() {

        String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=3";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse  response =null;
                try {
            response = httpClient.execute(httpGet);

                    System.out.println(response.toString());
        } catch (IOException e) {
            System.out.println("Response is NULL");
        }
        return response.toString();
    }
}



