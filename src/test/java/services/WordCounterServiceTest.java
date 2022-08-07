package services;

import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import services.impl.WordCounterServiceImpl;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class WordCounterServiceTest {

    private WordCounterService wordCounterService = new WordCounterServiceImpl();

    @Test
    public void testGetWordCountWithWordtring() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("sampleWord", 2);

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Map.Entry<String, Integer> firstEntry = entrySet.iterator().next();

        String resolvedString = wordCounterService.getWordCountWithWordString(firstEntry);

        assertEquals("2 sampleWord", resolvedString);
    }

    @Test
    public void testGetCharacterCountHashMapSortedInDecreasingOrder() {
        String sampleText = "the cat   is   in the bag";
        Map<String, Integer> hashMap = wordCounterService.getCharacterCountHashMapSortedInDecreasingOrder(sampleText);

        Set<Map.Entry<String, Integer>> mapEntries = hashMap.entrySet();

        Map.Entry<String, Integer> firstEntry = mapEntries.iterator().next();

        String firstKey = firstEntry.getKey();
        Integer firstValue = firstEntry.getValue();

        assertEquals("the", firstKey);
        assertEquals(Integer.valueOf(2), firstValue);
        assertEquals(Integer.valueOf(1), hashMap.get("cat"));
        assertEquals(Integer.valueOf(1), hashMap.get("is"));
        assertEquals(Integer.valueOf(1), hashMap.get("in"));
        assertEquals(Integer.valueOf(1), hashMap.get("bag"));
        assertEquals(5, mapEntries.size());
    }
}
