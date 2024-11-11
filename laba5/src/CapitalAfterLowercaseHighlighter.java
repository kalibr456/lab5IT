import java.util.regex.*;

public class CapitalAfterLowercaseHighlighter {
    public static void main(String[] args) {
        String text = "This is a test String with cases like eXample and aBnormal patterns.";

        System.out.println("Исходный текст: " + text);
        String highlightedText = highlightCapitalAfterLowercase(text);
        System.out.println("Обработанный текст: " + highlightedText);
    }

    public static String highlightCapitalAfterLowercase(String text) {
        String pattern = "(?<=[a-z])([A-Z])";

        try {
            Pattern compiledPattern = Pattern.compile(pattern);
            Matcher matcher = compiledPattern.matcher(text);

            // Заменяем все найденные случаи, оборачивая их знаками "!"
            StringBuffer highlightedText = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(highlightedText, "!" + matcher.group() + "!");
            }
            matcher.appendTail(highlightedText);

            return highlightedText.toString();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
            return text;
        }
    }
}
