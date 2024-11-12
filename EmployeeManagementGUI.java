// EmployeeManagementGUI.java
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagementGUI extends Frame implements ActionListener {
    private TextField tfId, tfName, tfDepartment;
    private TextArea taDisplay;
    private Button btnAdd, btnUpdate, btnView;
    private EmployeeManager employeeManager;

    public EmployeeManagementGUI() {
        // Initialize the employee manager
        employeeManager = new EmployeeManager();

        // Set up the GUI components
        setLayout(new FlowLayout());

        // Labels and text fields
        add(new Label("Employee ID:"));
        tfId = new TextField(10);
        add(tfId);

        add(new Label("Employee Name:"));
        tfName = new TextField(20);
        add(tfName);

        add(new Label("Department:"));
        tfDepartment = new TextField(20);
        add(tfDepartment);

        // Buttons for operations
        btnAdd = new Button("Add Employee");
        btnUpdate = new Button("Update Employee");
        btnView = new Button("View Employees");
        add(btnAdd);
        add(btnUpdate);
        add(btnView);

        // Text area to display employee information
        taDisplay = new TextArea(10, 50);
        taDisplay.setEditable(false);
        add(taDisplay);

        // Add action listeners for buttons
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnView.addActionListener(this);

        // Set up the frame
        setTitle("Employee Management System");
        setSize(600, 400);
        setVisible(true);
        
        // Close the window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Add Employee")) {
            addOrUpdateEmployee(false);
        } else if (action.equals("Update Employee")) {
            addOrUpdateEmployee(true);
        } else if (action.equals("View Employees")) {
            viewAllEmployees();
        }
    }

    private void addOrUpdateEmployee(boolean isUpdate) {
        String id = tfId.getText();
        String name = tfName.getText();
        String department = tfDepartment.getText();

        if (id.isEmpty() || name.isEmpty() || department.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        Employee emp = new Employee(id, name, department);
        employeeManager.addOrUpdateEmployee(emp);
        showInfo("Employee " + (isUpdate ? "updated" : "added") + " successfully.");
    }

    private void viewAllEmployees() {
        taDisplay.setText("");
        for (Employee emp : employeeManager.getAllEmployees()) {
            taDisplay.append(emp.toString() + "\n");
        }
    }

    private void showError(String message) {
        taDisplay.setText("Error: " + message);
    }

    private void showInfo(String message) {
        taDisplay.setText("Info: " + message);
    }

    public static void main(String[] args) {
        new EmployeeManagementGUI();
    }
}
