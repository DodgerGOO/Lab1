public class Task4 {
    public static void main(String[] args) {
        // Оголошення і ініціалізація двох матриць для множення
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Виклик методу множення матриць і отримання результату
        int[][] result = multiplyMatrices(matrix1, matrix2);

        // Виведення результату множення на екран
        System.out.println("Result of matrix multiplication:");
        printMatrix(result);
    }

    // Метод для множення двох матриць
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        // Перевірка, чи можливо виконати множення
        if (cols1 != matrix2.length) {
            throw new IllegalArgumentException("Number of columns of first matrix must be equal to number of rows of second matrix");
        }

        // Створення матриці для зберігання результату
        int[][] result = new int[rows1][cols2];

        // Проведення множення матриць
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    // Метод для виведення матриці на екран
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
