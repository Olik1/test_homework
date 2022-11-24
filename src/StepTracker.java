public class StepTracker {
    MonthData[] monthToData;
    Converter converter;
    int planStep;

    public StepTracker() {
        planStep = 10_000;
        converter = new Converter();
        monthToData = new MonthData[MonthData.MONTH_IN_YEAR];

        for (int i = 0; i < MonthData.MONTH_IN_YEAR; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setDayPlan(int steps) {
        planStep = steps;
        System.out.println("Ваша новая цель за день составила " + planStep + " шагов");
    }

    public void setStepsByDay(int month, int day, int steps) {
        monthToData[month].days[day] = steps;
        System.out.println("Пройденное вами количество шагов составило " + steps + " за " + day + " день в " + month + " месяце");
    }

    public void getStatistic(int month) {
        printStepsByDay(month);
        int totalStepsMonth = getTotalStepsbyMonth(month);
        System.out.println("Общее количество шагов за месяц: " + totalStepsMonth);
        System.out.println("Максимально количество шагов за месяц: " + getMaxStep(month));
        System.out.println("Среднее количество шагов за месяц: " + getAvgSteps(month));
        System.out.println("Пройденная дистанция за месяц: " + converter.getDistance(totalStepsMonth) + " км");
        System.out.println("Вы сожгли за месяц: " + converter.getSumKlc(totalStepsMonth) + " Ккал");
        System.out.println("Лучшая серия шагов в " + month + " месяце: " + getBestSeria(month));
    }

    public void printStepsByDay(int month) {
        for (int i = 0; i < MonthData.DAYS_IN_MONTH; i++) {
            System.out.println((i + 1) + " день: " + monthToData[month].days[i]);
        }
    }

    public int getTotalStepsbyMonth(int month) {
        int totalstep = 0;
        for (int i = 0; i < MonthData.DAYS_IN_MONTH; i++) {
            totalstep += monthToData[month].days[i];
        }
        return totalstep;
    }

    public int getMaxStep(int month) {
        int max = monthToData[month].days[0];
        for (int i = 1; i < MonthData.DAYS_IN_MONTH; i++) {
            if (max < monthToData[month].days[i]) {
                max = monthToData[month].days[i];
            }
        }
        return max;
    }

    public double getAvgSteps(int month) {
        return (double) getTotalStepsbyMonth(month) / MonthData.DAYS_IN_MONTH;
    }

    public int getBestSeria(int month) {
        int currentCount = 0;
        int bestCount = 0;
        for (int i = 0; i < MonthData.DAYS_IN_MONTH; i++) {
            if (monthToData[month].days[i] > planStep) {
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
