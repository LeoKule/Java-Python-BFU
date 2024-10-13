import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TaskManager {

    // Задача 1: Метод для нахождения наибольшей подстроки без повторяющихся символов
    public static String longestUniqueSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        String longestSubstring = "";

        HashSet<Character> set = new HashSet<>();
        int i = 0;

        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                if (set.size() > maxLength) {
                    maxLength = set.size();
                    longestSubstring = s.substring(start, i);
                }
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return longestSubstring;
    }

    // Задача 2: Метод для объединения двух отсортированных массивов
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Слияние массивов
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Добавление оставшихся элементов
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    // Задача 3: Метод для нахождения максимальной суммы подмассива (Алгоритм Кадане)
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];  // Максимальная сумма на текущий момент
        int maxEndingHere = arr[0];  // Максимальная сумма на текущем участке

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Задача 4: Поворот двумерного массива на 90 градусов по часовой стрелке
    public static int[][] rotateMatrix90(int[][] matrix) {
        int n = matrix.length;    // количество строк (и столбцов, так как матрица квадратная)
        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    // Задача 5: Нахождение пары элементов, сумма которых равна заданному числу (target)
    public static int[] findPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();  // Хранение просмотренных элементов

        for (int num : arr) {
            int complement = target - num;  // Ищем число, которое в сумме с num даст target
            if (set.contains(complement)) {
                return new int[]{complement, num};  // Найдена пара
            }
            set.add(num);  // Добавляем текущий элемент в множество
        }

        return null;  // Пара не найдена
    }

    // Задача 6: Нахождение суммы всех элементов двумерного массива
    public static int sumOfMatrixElements(int[][] matrix) {
        int sum = 0;

        // Проходим по каждому элементу матрицы
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите задачу для выполнения:");
            System.out.println("1. Найти наибольшую подстроку без повторяющихся символов");
            System.out.println("2. Объединить два отсортированных массива");
            System.out.println("3. Найти максимальную сумму подмассива");
            System.out.println("4. Повернуть двумерный массив на 90 градусов по часовой стрелке");
            System.out.println("5. Найти пару элементов в массиве, сумма которых равна заданному числу");
            System.out.println("6. Найти сумму всех элементов в двумерном массиве");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Поглощение новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите строку: ");
                    String input = scanner.nextLine();
                    String result1 = longestUniqueSubstring(input);
                    System.out.println("Наибольшая подстрока без повторяющихся символов: " + result1);
                    break;
                case 2:
                    System.out.print("Введите размер первого массива: ");
                    int size1 = scanner.nextInt();
                    int[] arr1 = new int[size1];
                    System.out.println("Введите элементы первого массива (по возрастанию): ");
                    for (int i = 0; i < size1; i++) {
                        arr1[i] = scanner.nextInt();
                    }

                    System.out.print("Введите размер второго массива: ");
                    int size2 = scanner.nextInt();
                    int[] arr2 = new int[size2];
                    System.out.println("Введите элементы второго массива (по возрастанию): ");
                    for (int i = 0; i < size2; i++) {
                        arr2[i] = scanner.nextInt();
                    }

                    int[] result2 = mergeSortedArrays(arr1, arr2);
                    System.out.println("Объединенный отсортированный массив: " + Arrays.toString(result2));
                    break;
                case 3:
                    System.out.print("Введите размер массива: ");
                    int size3 = scanner.nextInt();
                    int[] arr3 = new int[size3];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size3; i++) {
                        arr3[i] = scanner.nextInt();
                    }

                    int result3 = maxSubArraySum(arr3);
                    System.out.println("Максимальная сумма подмассива: " + result3);
                    break;
                case 4:
                    System.out.print("Введите размер двумерного массива (NxN): ");
                    int n = scanner.nextInt();
                    int[][] matrix = new int[n][n];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }

                    int[][] rotatedMatrix = rotateMatrix90(matrix);
                    System.out.println("Массив после поворота на 90 градусов: ");
                    for (int i = 0; i < n; i++) {
                        System.out.println(Arrays.toString(rotatedMatrix[i]));
                    }
                    break;
                case 5:
                    System.out.print("Введите размер массива: ");
                    int size5 = scanner.nextInt();
                    int[] arr5 = new int[size5];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size5; i++) {
                        arr5[i] = scanner.nextInt();
                    }

                    System.out.print("Введите целевую сумму (target): ");
                    int target = scanner.nextInt();

                    int[] result5 = findPairWithSum(arr5, target);
                    if (result5 != null) {
                        System.out.println("Найдена пара: " + Arrays.toString(result5));
                    } else {
                        System.out.println("Пара с суммой " + target + " не найдена.");
                    }
                    break;
                case 6:
                    System.out.print("Введите количество строк двумерного массива: ");
                    int rows = scanner.nextInt();
                    System.out.print("Введите количество столбцов двумерного массива: ");
                    int cols = scanner.nextInt();
                    int[][] matrix2 = new int[rows][cols];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrix2[i][j] = scanner.nextInt();
                        }
                    }

                    int sum = sumOfMatrixElements(matrix2);
                    System.out.println("Сумма всех элементов двумерного массива: " + sum);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
