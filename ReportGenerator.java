// finance_manager/reports/ReportGenerator.java
package reports;

import transaction.Transaction;

import java.util.List;

public class ReportGenerator {
    public static void generateReport(List<Transaction> transactions) {
        System.out.println("Transaction Report:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
