package com.nabivach.cache;

import java.util.Map;


public interface CacheFactory {

    Map<String, Object> createCache();
}
