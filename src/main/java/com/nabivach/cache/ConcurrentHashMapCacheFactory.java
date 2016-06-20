package com.nabivach.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by anabivach on 17/06/2016.
 */
@Component("concurrentHashMapCacheFactory")
public class ConcurrentHashMapCacheFactory implements CacheFactory {

    @Override
    public Map<String, Object> createCache() {
        return new ConcurrentHashMap<>();
    }
}
