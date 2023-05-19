import java.util.HashMap;

public class Checker {
    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;

    public Checker(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        this.yearlyReport = yearlyReport;
        this.monthlyReport = monthlyReport;
    }

    public boolean check() {
        boolean check = true;

        HashMap<Integer, Integer> incomeNumberMonth = new HashMap<>();
        HashMap<Integer, Integer> expenceNumberMonth = new HashMap<>();
//
        for (MonthData search : monthlyReport.monthReport) {
//
//            if (search.monthNumber != i) {
//                continue;
//            }
                if (search.is_expense == true) {
                    int monthExpence = 0;
                    monthExpence += search.quantity * search.unit_price;
                    expenceNumberMonth.put(search.monthNumber, expenceNumberMonth.getOrDefault(search.monthNumber, 0) + monthExpence);
                } else {
                    int monthIncome = 0;
                    monthIncome += search.quantity * search.unit_price;
                    incomeNumberMonth.put(search.monthNumber, incomeNumberMonth.getOrDefault(search.monthNumber, 0) + monthIncome);
                }
            }

        for (int i = 1; i <= incomeNumberMonth.size(); i++) {
           // if ((incomeNumberMonth.get(i) != yearlyReport.incomeByMonth.get(i)) || (expenceNumberMonth.get(i) != yearlyReport.expenseByMonth.get(i))) {
            int im = incomeNumberMonth.get(i);
            int iy = yearlyReport.incomeByMonth.get(i);
            int em = expenceNumberMonth.get(i);
            int ey = yearlyReport.expenseByMonth.get(i);
            if ((im != iy) || (em != ey)) {
                System.out.println("Обнаружено несоответствие отчетов за " + i + "-й месяц!");
            check = false;
            }
       }
        return check;
    }
}
