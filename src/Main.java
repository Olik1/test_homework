import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int userInput = -1;
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.setStepsByDay(
                        readValueMonth(),
                        readValueDay(),
                        readValueStep()
                );
            } else if (userInput == 2) {
                stepTracker.getStatistic(readValueMonth());

            } else if (userInput == 3) {
                stepTracker.setDayPlan(readValueStep());
            }
        }
        System.out.println("Программа завершена");
    }

    private static int readValueMonth() {
        while (true) {
            System.out.println("Введите месяц от 0 до 11");
            int month = scanner.nextInt();
            if (month < 0 || month > 11) {
                System.out.println("Указан неверный диапазон, попробуйте ввести месяц в диапазоне от 0 до 11!");
            } else {
                return month;
            }
        }
    }

    private static int readValueDay() {
        while (true) {
            System.out.println("Введите день от 0 до 29");
            int day = scanner.nextInt();
            if (day < 0 || day > 29) {
                System.out.println("Указан неверный диапазон, попробуйте ввести день в диапазоне от 0 до 29!");
            } else {
                return day;
            }
        }
    }

    private static int readValueStep() {
        while (true) {
            System.out.println("Укажите количество шагов");
            int steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            } else {
                return steps;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Получить статистику");
        System.out.println("3 - Изменить цель по количеству шагов");
        System.out.println("0 - Выход из приложения");
    }

}
