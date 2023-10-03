public class Task3 {
    public static void main(String[] args) {
        String email1 = "vladyslavkostuk@gmail.com";
        String email2 = "vladyslavkostukgmailcom";

        System.out.println("Email 1 is valid: " + validateEmail(email1));
        System.out.println("Email 2 is valid: " + validateEmail(email2));
    }

    public static boolean validateEmail(final String email) {
        // Перевірка, чи рядок не є порожнім
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Перевірка, чи є символ "@" у рядку
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            return false;
        }

        // Перевірка, чи є символ "." після символа "@"
        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) {
            return false;
        }

        // Перевірка, чи не є символ "." останнім символом в рядку
        if (dotIndex == email.length() - 1) {
            return false;
        }

        return true;
    }
}
