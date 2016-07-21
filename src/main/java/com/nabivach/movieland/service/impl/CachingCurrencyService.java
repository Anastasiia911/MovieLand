package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.entity.Currency;
import com.nabivach.movieland.service.CurrencyService;
import com.nabivach.movieland.util.deserializer.JsonParse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachingCurrencyService implements CurrencyService {

    @Autowired
    private JsonParse jsonReader;

    private Map<String, Currency> cacheCurrencyToday = new ConcurrentHashMap<>();

    @Override
    public String getJsonCurrencyFromNBU() throws IOException {
        return null;
    }

    private void fillCurrencyCacheToday(List<Currency> currencyList) {
        for (Currency currency : currencyList){
        cacheCurrencyToday.put(currency.getCcy(), currency);
    }
}
private void refreshCurrencyCache(){
    
}
}
