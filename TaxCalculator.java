
// Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create the GUI tax calculator system
public class TaxCalculator extends JFrame implements ActionListener {
    // Create GUI components (buttons, text fields, labels, etc.)
    private JLabel incomeLabel = new JLabel("Annual Income:");
    private JTextField incomeField = new JTextField(10);
    private JLabel taxLabel = new JLabel("Tax Obligation:");
    private JTextField taxField = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");

    // Constructor to create the GUI and add components
    public TaxCalculator() {
        // Set up the GUI window
        setTitle("Tax Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set up the layout and add components
        setLayout(new GridLayout(3, 2));
        add(incomeLabel);
        add(incomeField);
        add(taxLabel);
        add(taxField);
        add(calculateButton);

        // Add event listener to the Calculate button
        calculateButton.addActionListener(this);

        // Set the GUI visible
        setVisible(true);
    }

    // Event listener for the Calculate button
    public void actionPerformed(ActionEvent e) {
        // Get the user input for annual income
        double income = Double.parseDouble(incomeField.getText());

        // Calculate the tax obligation using the formula
        double tax = 0;
        if (income <= 50000) {
            tax = income * 0.1;
        } else if (income > 50000 && income <= 100000) {
            tax = income * 0.2;
        } else {
            tax = income * 0.3;
        }

        // Check for division by zero
        if (income == 0) {
            JOptionPane.showMessageDialog(null, "Error: Division by zero");
            return;
        }

        // Display the calculated tax obligation
        taxField.setText(Double.toString(tax));
    }

    public static void main(String[] args) {
        // Create a new instance of the TaxCalculator
        new TaxCalculator();
    }
}