import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    FileReader fileReader = new FileReader();
    public  ArrayList<MonthData> monthReport = new ArrayList<>();

    public void loadFile(int monthNumber, String fileName) {
        ArrayList lines = fileReader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++){
            String line = String.valueOf(lines.get(i)); // item_name,is_expense,quantity,unit_price
            String[] parts =  line.split(",");
            String itemName = parts[0];
            boolean is_expense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unit_price = Integer.parseInt(parts[3]);

            MonthData reports = new MonthData(itemName, is_expense, quantity, unit_price, monthNumber);
            monthReport.add(reports);
        }
    }

    public void mostProfitableItem (int monthNumber) { // самый прибыльный товар, название товара и сумму;
        HashMap<String, Integer> profitableItem = new HashMap<>();
        for (MonthData item : monthReport) {
            if (item.monthNumber != monthNumber) {
                continue;
            }
            if (item.is_expense == false) {
                int profit = item.quantity * item.unit_price;
                profitableItem.put(item.itemName, profit);
            }
        }
        String maxItem = null;
        for (String name : profitableItem.keySet()) {
            if (maxItem == null) {
                maxItem = name;
                continue;
            }
            if (profitableItem.get(maxItem) < profitableItem.get(name)) {
                maxItem = name;
            }
        }
        System.out.println("Самый прибыльный товар - " + maxItem + ", его продали на сумму - " + profitableItem.get(maxItem));
    }

    public  void mostExpensiveItem( int monthNumber) { // название товара и сумму.
        HashMap<String, Integer> expensiveItem = new HashMap<>();
        for (MonthData item : monthReport) {
            if (item.monthNumber != monthNumber) {
                continue;
            }
            if (item.is_expense == true) {
                int expense = item.quantity * item.unit_price;
                expensiveItem.put(item.itemName, expense);
            }
        }
        String maxItem = null;
        for (String name : expensiveItem.keySet()) {
            if (maxItem == null) {
                maxItem = name;
                continue;
            }
            if (expensiveItem.get(maxItem) < expensiveItem.get(name)) {
                maxItem = name;
            }
        }
        System.out.println("Самая большая трата пришлась на товар - " + maxItem + ", на него потратили - " + expensiveItem.get(maxItem));
    }

    public boolean checkMonthlyReport() {
        boolean monthlyReport = true;
        if (monthReport.size() == 0) {
            monthlyReport = false;
        }
        return monthlyReport;
    }
}
