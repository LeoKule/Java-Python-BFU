import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите задание:");
            System.out.println("1. Сиракузская последовательность");
            System.out.println("2. Знакочередующаяся сумма ряда");
            System.out.println("3. Ищем клад");
            System.out.println("0. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    syracuseSequence(scanner);
                    break;
                case 2:
                    alternatingSum(scanner);
                    break;
                case 3:
                    treasureHunt(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    // Задание 1: Сиракузская последовательность
    public static void syracuseSequence(Scanner scanner) {
        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();
        int steps = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }

        System.out.println("Количество шагов: " + steps);
    }

    // Задание 2: Знакочередующаяся сумма ряда
    public static void alternatingSum(Scanner scanner) {
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Введите число " + i + ": ");
            int num = scanner.nextInt();
            if (i % 2 != 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        System.out.println("Знакочередующаяся сумма: " + sum);
    }

    // Задание 3: Ищем клад
    public static void treasureHunt(Scanner scanner) {
        System.out.print("Введите координату X клада: ");
        int treasureX = scanner.nextInt();
        System.out.print("Введите координату Y клада: ");
        int treasureY = scanner.nextInt();

        int currentX = 0;
        int currentY = 0;
        int steps = 0;

        while (true) {
            System.out.print("Введите направление (север, юг, запад, восток) или 'стоп': ");
            String direction = scanner.next();

            if (direction.equals("стоп")) {
                break;
            }

            System.out.print("Введите количество шагов: ");
            int distance = scanner.nextInt();

            switch (direction) {
                case "север":
                    currentY += distance;
                    break;
                case "юг":
                    currentY -= distance;
                    break;
                case "восток":
                    currentX += distance;
                    break;
                case "запад":
                    currentX -= distance;
                    break;
            }

            steps++;

            if (currentX == treasureX && currentY == treasureY) {
                break;
            }
        }

        System.out.println("Минимальное количество указаний карты: " + steps);
    }
}
