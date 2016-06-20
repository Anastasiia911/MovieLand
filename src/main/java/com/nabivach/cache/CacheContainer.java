package com.nabivach.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anabivach on 17/06/2016.
 */
@Component
public class CacheContainer {

    @Autowired
    private CacheFactory cacheFactory;

    private Map<String, Map<String, Object>> caches = new HashMap<>();

    public synchronized Map<String, Object> getCache(String cacheId) {
        if (!caches.containsKey(cacheId)) {
            caches.put(cacheId, cacheFactory.createCache());
        }
        return caches.get(cacheId);
    }
}
