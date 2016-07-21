package com.nabivach.movieland.service;


import java.io.IOException;

public interface CurrencyService {

    double getPriceDependingOnCurrency(String ccy, double price);

    double getCurrencyFromNBU(String ccy) throws IOException;
}

