import java.util.Arrays;
import java.util.Comparator;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = {"RX7", "GTR R34", "S15", "GTI",};

        // Сортування масиву за кількістю великих літер
        Arrays.sort(strings, new UpperCaseLetterComparator());

        // Виведення відсортованого масиву
        System.out.println("The array is sorted by a large number of letters:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}

// Компаратор для порівняння рядків за кількістю великих літер
class UpperCaseLetterComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int upperCaseCount1 = countUpperCaseLetters(str1);
        int upperCaseCount2 = countUpperCaseLetters(str2);

        // Порівняння за кількістю великих літер
        return Integer.compare(upperCaseCount1, upperCaseCount2);
    }

    // Метод для підрахунку кількості великих літер у рядку
    private int countUpperCaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}
