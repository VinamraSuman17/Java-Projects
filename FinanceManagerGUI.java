// finance_manager/user/FinanceManagerGUI.java
package user;

import transaction.Transaction;
import transaction.TransactionManager;
import reports.ReportGenerator;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class FinanceManagerGUI extends Frame implements ActionListener {
    private TextField tfDescription, tfAmount, tfCategory;
    private Button btnAdd, btnView;
    private List transactionList;
    private TransactionManager transactionManager;

    public FinanceManagerGUI() {
        transactionManager = new TransactionManager();

        setLayout(new FlowLayout());

        // Input fields
        add(new Label("Description:"));
        tfDescription = new TextField(20);
        add(tfDescription);

        add(new Label("Amount:"));
        tfAmount = new TextField(10);
        add(tfAmount);

        add(new Label("Category:"));
        tfCategory = new TextField(15);
        add(tfCategory);

        // Buttons
        btnAdd = new Button("Add Transaction");
        btnView = new Button("View Transactions");
        add(btnAdd);
        add(btnView);

        // Transaction List
        transactionList = new List(10);
        add(transactionList);

        // Add action listeners
        btnAdd.addActionListener(this);
        btnView.addActionListener(this);

        // Frame settings
        setTitle("Personal Finance Manager");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Add Transaction")) {
            addTransaction();
        } else if (action.equals("View Transactions")) {
            viewTransactions();
        }
    }

    private void addTransaction() {
        String description = tfDescription.getText();
        String amountText = tfAmount.getText();
        String category = tfCategory.getText();

        if (description.isEmpty() || amountText.isEmpty() || category.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);
            Transaction transaction = new Transaction(description, amount, category, LocalDate.now());
            transactionManager.addTransaction(transaction);
            showInfo("Transaction added successfully.");
        } catch (NumberFormatException e) {
            showError("Invalid amount. Please enter a numeric value.");
        }
    }

    private void viewTransactions() {
        transactionList.removeAll();
        for (Transaction transaction : transactionManager.getTransactions()) {
            transactionList.add(transaction.toString());
        }
    }

    private void showError(String message) {
        transactionList.add("Error: " + message);
    }

    private void showInfo(String message) {
        transactionList.add("Info: " + message);
    }

    public static void main(String[] args) {
        new FinanceManagerGUI();
    }
}
