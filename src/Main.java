import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        Checker checker = new Checker(yearlyReport, monthlyReport);

        System.out.println("Вас приветствует программа для бухгалтерии!");

        while (true) {
            menu();
            int command = scanner.nextInt();

            if (command == 1) { // считывает месячные отчеты
                for (int i = 1; i < 4; i++) {
                    int monthNumber = i;
                    String fileName = "m.20210" + i + ".csv";
                    monthlyReport.loadFile(monthNumber, fileName);
                    System.out.println("Отчет за " + i + " месяц считан.");
                }
            }
            if (command == 2) { // считывает годовой отчет
                yearlyReport.loadFile("y.2021.csv"); // номер года!!!!
                System.out.println("Годовой отчет считан.");
            }
            if (command == 3) { // сверяет отчеты
                if (yearlyReport.checkYearlyReport() == false) {
                    System.out.println("Сначала нужно считать отчет за год!");
                } else if (monthlyReport.checkMonthlyReport() == false) {
                    System.out.println("Сначала нужно считать отчеты за месяц!");
                } else if (checker.check() == true) {
                    System.out.println("Операция выполнена успешно!");
                }
            }
            if (command == 4) { // выходит информацию за месяц
                if (monthlyReport.checkMonthlyReport() == false) {
                    System.out.println("Сначала нужно считать отчеты за месяц!");
                } else {
                    System.out.println("За какой месяц вы хотите узнать статистику? Введите число от 1 до 3:");
                    int month = scanner.nextInt();
                    System.out.println("Статистика за " + month + "-й месяц:");
                    monthlyReport.mostProfitableItem(month);
                    monthlyReport.mostExpensiveItem(month);
                }
            }
            if (command == 5) { // выводит информацию за год
                if (yearlyReport.checkYearlyReport() == false) {
                    System.out.println("Сначала нужно считать отчет за год!");
                } else {
                    System.out.println("Годовая статистика за 2021 год:");
                    yearlyReport.getIncomeByMonth();
                    yearlyReport.getAverageExpense();
                    yearlyReport.getAverageIncome();
                }

            }
            if (command == 0) { // выход
                System.out.println("Если вы действительно хотите выйти - введите \"ДА\"");
                String exit = scanner.next();
                if (exit.equals("ДА")){
                    break;

                }

            }

        }

    }
    public static void menu () {
        System.out.println("Что бы вы хотели сделать?");
        System.out.println("\t1 - Считать месячные отчеты");
        System.out.println("\t2 - Считать годовой отчет");
        System.out.println("\t3 - Сверить отчеты");
        System.out.println("\t4 - Вывести статистику за месяц");
        System.out.println("\t5 - Вывести статистику за год");
        System.out.println("\t0 - Выход");
    }

}

