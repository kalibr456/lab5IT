import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Password123";

        if (isPasswordValid(password)) {
            System.out.println("Пароль корректен.");
        } else {
            System.out.println("Пароль не соответствует требованиям.");
        }
    }

    public static boolean isPasswordValid(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        try {
            Pattern pattern = Pattern.compile(passwordPattern);
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке пароля: " + e.getMessage());
            return false;
        }
    }
}
