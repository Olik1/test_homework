import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    Converter converter;
    int planStep;
    int steps;
    int idDay;
    int idMonth;

    public StepTracker() {
        this.planStep = 10_000;
        this.converter = new Converter();
        this.monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            this.monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days;

        public MonthData() {
            this.days = new int[30];
            for (int i = 0; i < days.length; i++) {
                days[i] = steps;
            }
        }
    }


    public void changeDaySteps(int planStep) {
        this.planStep = planStep;
        System.out.println("Ваша новая цель за день составила " + this.planStep + " шагов");
    }

    public void setStepsByDay(int idMonth, int idDay, int steps) {
        this.idMonth = idMonth;
        if (idMonth < 0 && idMonth >= 12) {
            System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            return;
        }
        this.idDay = idDay;
        if (idDay < 0 && idDay > 30) {
            System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            return;
        }

        this.steps = steps;
        if (steps < 0) {
            System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
        } else {
            monthToData[idMonth].days[idDay] = steps;
            System.out.println("Пройденное вами количество шагов составило " + this.steps + " за " + this.idDay + " день " + "в " + this.idMonth + " месяце");
        }
    }

    public void getStatistic(int month) {
        printStepsByDay(month);
        System.out.println("Общее количество шагов за месяц: " + getTotalStepsbyMonth(month));
        System.out.println("Максимально количество шагов за месяц: " + getMaxStep(month));
        System.out.println("Среднее количество шагов за месяц: " + getAvgSteps(month));
        System.out.println("Пройденная дистанция за месяц: " + converter.getDistance(getTotalStepsbyMonth(month)) + " км.");
        System.out.println("Вы сожгли за месяц: " + converter.getSumKlc(this.steps) + " килокалорий");
        System.out.println("Лучшая серия шагов " + "в " + month + " месяце:  " + getBestSeria(month));
    }

    public void printStepsByDay(int month) {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + monthToData[month].days[i]);
        }
    }

    public int getTotalStepsbyMonth(int idMonth) {
        int totalstep = 0;
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            totalstep += monthToData[idMonth].days[i];
        }
        return totalstep;
    }


    public int getMaxStep(int month) {
        int max = monthToData[month].days[0];
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            if (max < monthToData[month].days[i]) {
                max = monthToData[month].days[i];
            }
        }
        return max;
    }

    public double getAvgSteps(int month) {
        double avgSteps = 0.0;
        avgSteps = getTotalStepsbyMonth(month) / monthToData[month].days.length;
        return avgSteps;
    }

    public int getBestSeria(int idMonth) {
        int currentCount = 0;
        int bestCount = 0;
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            if (monthToData[idMonth].days[i] > planStep) {
                currentCount = currentCount + 1;
            } else {
                currentCount = 0;
            }
            if (currentCount > bestCount) {
                bestCount = currentCount;
            }
        }
        return bestCount;
    }
}
