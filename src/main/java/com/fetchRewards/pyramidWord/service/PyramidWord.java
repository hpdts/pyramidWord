package com.fetchRewards.pyramidWord.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

@Service
public class PyramidWord {

    public boolean isPyramid(String word){
        if(word == null){
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for(char letter : word.toCharArray()){
            counts.put(letter, counts.getOrDefault(letter, 0) + 1);
        }
        Map<Character, Integer> countsSorted = sortMap(counts);
        int i = 1;
        for(Map.Entry<Character, Integer> entry : countsSorted.entrySet()){
            int count = entry.getValue();
            if(count != i){
                return false;
            }
            i++;
        }
        return true;
    }

    public Map<Character, Integer> sortMap(Map<Character, Integer> counts){
        Comparator<Map.Entry<Character, Integer>> valueComparator = (e1, e2) -> {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return v1.compareTo(v2);
        };

        Set<Entry<Character, Integer>> entries = counts.entrySet();
        List<Entry<Character, Integer>> listOfEntries = new ArrayList<>(entries);
        listOfEntries.sort(valueComparator);
        Map<Character, Integer> sortedByValue = new LinkedHashMap<>(listOfEntries.size());

        for(Entry<Character, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }
}
