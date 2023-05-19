import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    FileReader fileReader = new FileReader();
    public  HashMap<Integer, Integer>  incomeByMonth = new HashMap<>();
    public  HashMap<Integer, Integer>  expenseByMonth = new HashMap<>();
    public void loadFile(String fileName) {

        ArrayList lines = fileReader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++){
            String line = String.valueOf(lines.get(i)); // month,amount,is_expense
            String[] parts =  line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean is_expense = Boolean.parseBoolean(parts[2]);

            if (is_expense == false) {
                incomeByMonth.put(month, amount);
            } else {
                expenseByMonth.put(month, amount);
            }

        }
    }

    public void getIncomeByMonth(){ // пишет прибыль по месяцам

        for (int i = 1; i <= incomeByMonth.size(); i++) {
            int income = incomeByMonth.get(i) - expenseByMonth.get(i);
            System.out.println("Прибыль за " + i + "-й месяц составила: " + income);
        }
     }

    public void getAverageExpense() {// средний расход в году
        int sum = 0;
        for (Integer expense : expenseByMonth.keySet()){
            sum += expenseByMonth.get(expense);
        }
        int averageExpense = sum / expenseByMonth.size();
        System.out.println("Средний расход за год составил " + averageExpense);
    }

    public void getAverageIncome() {// средний доход в году
        int sum = 0;
        for (Integer income : incomeByMonth.keySet()){
            sum += incomeByMonth.get(income);
        }
        int averageIncome = sum / incomeByMonth.size();
        System.out.println("Средний доход за год составил " + averageIncome);
    }

    public boolean checkYearlyReport() {
        boolean yearlyReport = true;
        if ((incomeByMonth.size() == 0) || (expenseByMonth.size() == 0)) {
            yearlyReport = false;
        }
    return yearlyReport;
    }

}
