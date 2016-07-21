package com.nabivach.movieland.service.impl;


import com.nabivach.movieland.service.CurrencyService;
import com.nabivach.movieland.util.deserializer.JsonParse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class GenericCurrencyService implements CurrencyService {

    @Autowired
    private JsonParse jsonReader;

    @Override
    public double getPriceDependingOnCurrency(String ccy, double price) {
        double convertedPrice = price;

        if (ccy.equals("UAH")) {
            return convertedPrice;
        }
        if (ccy.equals("USD")) {
            return convertedPrice;
        }
        if (ccy.equals("EUR")) {
            return convertedPrice;
        }
        return convertedPrice;
    }

    @Override
    public double getCurrencyFromNBU(String ccy) throws IOException {

        String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=3";
        double currencyRate = 0;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = httpClient.execute(httpGet);
        //List<Currency> currency = jsonReader.parseJson(response.toString(), Currency.class);
        //double currencyRate = currency.getSale();

        System.out.println(response.toString());
        return 0;
    }

    public static void main(String[] args) throws IOException {
        GenericCurrencyService  genericCurrencyService = new GenericCurrencyService();
        genericCurrencyService.getCurrencyFromNBU(" ");

    }
}



