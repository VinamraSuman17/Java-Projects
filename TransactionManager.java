// finance_manager/transactions/TransactionManager.java
package transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactions;
    private String filename = "data/transactions.txt";

    public TransactionManager() {
        transactions = new ArrayList<>();
        loadTransactions();
    }

    public void loadTransactions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            transactions = (List<Transaction>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, starting with an empty list
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
    }

    public void saveTransactions() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(transactions);
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        saveTransactions();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
