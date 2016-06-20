package com.nabivach.cache;

import java.util.Map;

/**
 * Created by anabivach on 17/06/2016.
 */
public interface CacheFactory {

    Map<String, Object> createCache();
}
