package com.coding.interview;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);

        Iterator<String> iterator = map.keySet().iterator();

        int i =0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            if(i==0){
                iterator.remove();
            }
            map.put("Fifth", 50);
            i++;
        }
        System.out.println(map);

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Iterator<String> iterator1 = list.iterator();
        i=0;
        while (iterator1.hasNext()){
            String key = iterator1.next();
            if(i==0) {
                iterator1.remove();
            }
            i++;
        }

        System.out.println(list);
    }
}
