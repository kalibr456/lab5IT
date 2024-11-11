import java.util.regex.*;
import java.util.ArrayList;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple and apricot are amazing fruits, but oranges are also great.";
        char startingLetter = 'a';

        System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "':");
        findWordsStartingWith(text, startingLetter);
    }

    public static void findWordsStartingWith(String text, char startingLetter) {
        String pattern = "\\b" + Character.toLowerCase(startingLetter) + "[a-zA-Z]*\\b|\\b" + Character.toUpperCase(startingLetter) + "[a-zA-Z]*\\b";

        try {
            Pattern compiledPattern = Pattern.compile(pattern);
            Matcher matcher = compiledPattern.matcher(text);

            ArrayList<String> words = new ArrayList<>();
            while (matcher.find()) {
                words.add(matcher.group());
            }

            if (words.isEmpty()) {
                System.out.println("Слов, начинающихся с заданной буквы, не найдено.");
            } else {
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при поиске слов: " + e.getMessage());
        }
    }
}
