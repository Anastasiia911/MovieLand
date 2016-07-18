package com.nabivach.movieland.service;


public interface CurrencyService {

    double getPriceDependingOnCurrency(String ccy, double price);

    double getCurrencyFromNBU(String ccy);
}

