package com.nabivach.movieland.service.impl;


import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CurrencyService;

import java.util.List;

public class GenericCurrencyService implements CurrencyService {


    @Override
    public double getPriceDependingOnCurrency(String ccy, double price) {
        if (ccy.equals("UAH")) {
            return price;
        }
        if (ccy.equals("USD")) {
            return price;
        }
        if (ccy.equals("EUR")) {
            return price;
        }
        return price;
    }

    @Override
    public double getCurrencyFromNBU(String ccy) {

        String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=3";
        double currencyRate = 0;

        return currencyRate;
    }
}
