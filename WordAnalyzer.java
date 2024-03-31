import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordAnalyzer {
    public static void main(String[] args) {
        File file = new File("input.txt");
        List<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }

        // Подсчет количества слов в файле
        int totalWords = words.size();
        System.out.println("Количество слов в файле: " + totalWords);

        // Нахождение самого длинного слова
        String longestWord = words.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        // Анализ частоты слов
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        System.out.println("Частота каждого слова в файле:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}