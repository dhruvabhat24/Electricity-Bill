import javax.swing.*;

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Electricity Bill Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Authentication
        String password = JOptionPane.showInputDialog(frame, "Enter Password:");

        if (!"1234".equals(password)) {
            JOptionPane.showMessageDialog(frame, "Authentication Failed");
            return; // Exit if the password is incorrect
        } else {
            JOptionPane.showMessageDialog(frame, "Authentication Successful");
        }

        // Asking for the electricity usage
        String usageInput = JOptionPane.showInputDialog(frame, "Enter Electricity Usage (kWh):");
        double usage;
        try {
            usage = Double.parseDouble(usageInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            return;
        }

        double bill = calculateBill(usage);
        // Display the bill in a label on the window
        JLabel billLabel = new JLabel("<html><body><h2>Karnataka State </h2>"
                + "<h2>Electricity Bill </h2>"
                + "<p>Customer ID: 123456789</p>"
                + "<p>Units Consumed: " + usage + " kWh</p>"
                + "<p>Total Bill: ₹" + String.format("%.2f", bill) + "</p>"
                + "<p>Thank you for your payment.</p></body></html>");
        billLabel.setBounds(70, 30, 300, 200);
        billLabel.setOpaque(true);
        // Background color: light gray
        billLabel.setBackground(java.awt.Color.LIGHT_GRAY);
        billLabel.setForeground(java.awt.Color.BLACK);
        billLabel.setFont(new java.awt.Font("TimesNewRoman", java.awt.Font.PLAIN, 20));
        frame.add(billLabel);

        // Display the window
        frame.setVisible(true);
    }

    public static double calculateBill(double units) {
        double amount;
        if (units <= 100) {
            amount = units * 4.50;
        } else if (units <= 200) {
            amount = 100 * 4.50 + (units - 100) * 3.80;
        } else if (units <= 300) {
            amount = 100 * 4.50 + 100 * 3.80 + (units - 200) * 6.00;
        } else {
            amount = 100 * 4.50 + 100 * 3.80 + 100 * 6.00 + (units - 300) * 8.00;
        }
        return amount;
    }
}