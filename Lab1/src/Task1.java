import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення першого числа
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        // Введення операції (+, -, *, /)
        System.out.print("Enter operation (+, -, *, /): ");
        String operator = scanner.next();

        // Введення другого числа
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int result;

        // Виконання операції та обробка винятків
        try {
            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    result = divide(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong operation: " + operator);
            }
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division on 0!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    // Метод для додавання чисел
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    // Метод для віднімання чисел
    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    // Метод для множення чисел
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Метод для ділення чисел
    public static int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division on 0 is impossible");
        }
        return num1 / num2;
    }
}
