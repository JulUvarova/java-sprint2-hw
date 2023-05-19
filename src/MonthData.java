public class MonthData {
    public String itemName;
    public boolean is_expense;
    public int quantity;
    public int unit_price;
    public int monthNumber;



    public MonthData(String itemName, boolean is_expense, int quantity, int unit_price, int monthNumber) {
        this.itemName = itemName;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.monthNumber = monthNumber;
    }
}
