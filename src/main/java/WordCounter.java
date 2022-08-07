import services.WordCounterService;
import java.util.*;
import services.impl.WordCounterServiceImpl;

public class WordCounter {
    private static WordCounterService wordCounterService = new WordCounterServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String inputString = scanner.nextLine();

        Map<String, Integer> wordCountMap = wordCounterService.getCharacterCountHashMapSortedInDecreasingOrder(inputString);

        printWordCounts(wordCountMap);
    }

    private static void printWordCounts(Map<String, Integer> wordCountMap) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String wordCountString = wordCounterService.getWordCountWithWordString(entry);
            System.out.println(wordCountString);
        }
    }
}
