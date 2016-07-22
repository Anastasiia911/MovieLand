package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.entity.Currency;
import com.nabivach.movieland.service.CurrencyService;
import com.nabivach.movieland.util.deserializer.JsonParse;
import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CachingCurrencyService implements CurrencyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CachingCurrencyService.class);

    @Autowired
    private JsonParse jsonParse;

    @Autowired
    private GenericCurrencyService genericCurrencyService;

    private Map<String, Currency> cacheCurrencyToday = new ConcurrentHashMap<>();

    @Override
    public String getJsonCurrencyFromNBU() throws IOException {
        return genericCurrencyService.getJsonCurrencyFromNBU();
    }

    public double getRateByRequest(String ccy){
        return cacheCurrencyToday.get(ccy).getSale();
    }

    private void fillCurrencyCacheToday(List<Currency> currencyList) {
        for (Currency currency : currencyList) {
            cacheCurrencyToday.put(currency.getCcy(), currency);
        }
    }

    public void initIt() throws Exception {
        System.out.println("Init method started" );
        refreshCurrencyCache();
            }
    //Currency should be daily refreshed at 11 AM
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    private void refreshCurrencyCache() throws IOException {
        LOGGER.debug("Start daily currency refresh from NBU ..");
        String jsonCurrencyFromNBUList = genericCurrencyService.getJsonCurrencyFromNBU();
        System.out.println("jsonCurrencyFromNBUList="+jsonCurrencyFromNBUList);
        fillCurrencyCacheToday(jsonParse.parseJsonList(jsonCurrencyFromNBUList,Currency.class));
        System.out.println(cacheCurrencyToday.get("USD"));
        LOGGER.debug("Finishing daily currency refresh from NBU ..");
    }

}
