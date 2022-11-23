import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int monthnumber;
    public static int daynumber;
    public static int steps;

    public static void main(String[] args) {
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                monthnumber = setValueMonth();
                daynumber = setValueDay();
                steps = setValueStep();
                stepTracker.setStepsByDay(monthnumber, daynumber, steps);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца для получения статистики");
                stepTracker.getStatistic(monthnumber);

            } else if (userInput == 3) {
                System.out.println("Установите цель ваших шагов на день");
                int newplanstep = scanner.nextInt();
                if (newplanstep < 0) {
                    System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
                    break;
                } else {
                    stepTracker.changeDaySteps(newplanstep);
                }

            } else if (userInput == 0) {
                break;
            }
        }
        System.out.println("Программа завершена");
    }

    public static int setValueMonth() {
        while (true) {
            System.out.println("Введите месяц от 0 до 11");
            int monthnumber = scanner.nextInt();
            if (monthnumber < 0 && monthnumber > 12) {
                System.out.println("Указан неверный диапазон, попробуйте ввести месяц в диапазоне от 0 до 11!");
            } else {
                return monthnumber;
            }
        }
    }

    public static int setValueDay() {
        while (true) {
            System.out.println("Введите день от 0 до 29");
            int daynumber = scanner.nextInt();
            if (daynumber < 0 && daynumber > 30) {
                System.out.println("Указан неверный диапазон, попробуйте ввести день в диапазоне от 0 до 29!");
            } else {
                return daynumber;
            }
        }
    }

    public static int setValueStep() {
        while (true) {
            System.out.println("Укажите количество шагов пройденных за сегодня");
            int stepssum = scanner.nextInt();
            if (stepssum < 0) {
                System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            } else {
                return stepssum;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день"); // done
        System.out.println("2 - Получить статистику");
        System.out.println("3 - Изменить цель по количеству шагов");// done
        System.out.println("0 - Выход из приложения");
    }
}
