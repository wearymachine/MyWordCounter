package services.impl;

import services.WordCounterService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounterServiceImpl implements WordCounterService {

    @Override
    public String getWordCountWithWordString(Map.Entry<String, Integer> entry) {
        return String.format("%s %s", entry.getValue(), entry.getKey());
    }

    @Override
    public Map<String, Integer> getCharacterCountHashMapSortedInDecreasingOrder(String string) {
        Map<String, Integer> characterCountMap = new HashMap<>();
        String whiteSpace = "\\s+";
        String[] words = string.split(whiteSpace);

        for (String word : words) {
            int newCount = characterCountMap.containsKey(word) ? characterCountMap.get(word) + 1 : 1;
            characterCountMap.put(word, newCount);
        }

        return characterCountMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
