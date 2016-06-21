package com.nabivach.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class CacheContainer {

    @Autowired
    private CacheFactory cacheFactory;

    private Map<String, Map<String, Object>> caches = new HashMap<>();

    @PostConstruct
    public synchronized Map<String, Object> getCache(String cacheId) { //cacheId = genres;
        if (!caches.containsKey(cacheId)) {
            caches.put(cacheId, cacheFactory.createCache());
        }

        return caches.get(cacheId);
    }
}
