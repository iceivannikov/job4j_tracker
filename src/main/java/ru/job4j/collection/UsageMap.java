package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("ivannikov@yandex.ru", "Viktor Ivannikov");
        Set<Map.Entry<String, String>> entry = map.entrySet();
        for (Map.Entry<String, String> stringEntry : entry) {
            System.out.println(stringEntry.getKey() + "=" + stringEntry.getValue());
        }
    }
}
