package services;

import java.util.Map;

public interface WordCounterService {
    public String getWordCountWithWordString(Map.Entry<String, Integer> entry);

    public Map<String, Integer> getCharacterCountHashMapSortedInDecreasingOrder(String string);
}
