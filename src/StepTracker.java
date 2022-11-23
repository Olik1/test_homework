import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    Converter converter;
    int planStep;
    int idMonth;

    public StepTracker() {
        this.planStep = 10_000;
        this.converter = new Converter();
        this.monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            this.monthToData[i] = new MonthData();
        }
    }

    public void setDayPlan(int steps) {
        planStep = steps;
        System.out.println("Ваша новая цель за день составила " + planStep + " шагов");
    }

    public void setStepsByDay(int idMonth, int idDay, int steps) {
        monthToData[idMonth].days[idDay] = steps;
        System.out.println("Пройденное вами количество шагов составило " + steps + " за " + idDay + " день " + "в " + idMonth + " месяце");

    }

    public void getStatistic(int month) {
        printStepsByDay(month);
        int totalStepsMonth = getTotalStepsbyMonth(month);
        System.out.println("Общее количество шагов за месяц: " + getTotalStepsbyMonth(month));
        System.out.println("Максимально количество шагов за месяц: " + getMaxStep(month));
        System.out.println("Среднее количество шагов за месяц: " + getAvgSteps(month));
        System.out.println("Пройденная дистанция за месяц: " + converter.getDistance(totalStepsMonth) + " км");
        System.out.println("Вы сожгли за месяц: " + converter.getSumKlc(totalStepsMonth) + " Ккал");
        System.out.println("Лучшая серия шагов в " + month + " месяце:  " + getBestSeria(month));
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
        for (int i = 1; i < monthToData[idMonth].days.length; i++) {
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
                currentCount++;
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
