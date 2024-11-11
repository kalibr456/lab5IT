import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Цена продукта составляет $19.99, а скидка - 10%. Окончательная стоимость - 17.99";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        try {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при поиске чисел: " + e.getMessage());
        }
    }
}
