// finance_manager/transactions/Transaction.java
package transaction;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private String description;
    private double amount;
    private String category;
    private LocalDate date;

    public Transaction(String description, double amount, String category, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " - " + description + " (" + category + "): $" + amount;
    }
}
