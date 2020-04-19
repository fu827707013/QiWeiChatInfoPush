package com.example.demo.utils;

import java.util.List;
import java.util.Map;

/**
 * (description)
 * created at 2017/9/30
 *
 * @author laowang
 */
public interface MapInitializer<K, V>  {
    void init(Map<K, V> m);

    void initListMap(List<Map<K, V>> m);
}




