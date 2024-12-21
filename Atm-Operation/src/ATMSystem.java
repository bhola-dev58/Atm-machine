import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;

public class ATMSystem extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel mainPanel, loginPanel, transactionPanel;
    private JButton loginButton, registerButton, insertCardButton, resetPinButton, withdrawButton, depositButton, balanceButton, miniStatementButton, logoutButton;
    private JTextField pinField, cardNumberField;
    private JLabel balanceLabel;
    private HashMap<String, User> atmCardData = new HashMap<>();
    private String currentCardNumber;
    private boolean isCardInserted = false; // New flag to track ATM card insertion

    // Inner class to represent a User
    private static class User {
        String name;
        String accountNumber;
        String pin;
        int balance;
        String lastTransaction;
        String transactionDateTime;
        LinkedList<String> transactionHistory;

        public User(String name, String accountNumber, String pin) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = 5000; // Default balance
            this.lastTransaction = "None";
            this.transactionDateTime = "N/A";
            this.transactionHistory = new LinkedList<>();
        }
    }

    public ATMSystem() {
        setTitle("ATM Operation Machine");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel headingLabel = new JLabel("ATM Operation Machine", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(headingLabel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPanel = createLoginPanel();
        transactionPanel = createTransactionPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(transactionPanel, "Transaction");

        JPanel paddedPanel = new JPanel(new BorderLayout());
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        paddedPanel.add(mainPanel, BorderLayout.CENTER);

        add(paddedPanel, BorderLayout.CENTER);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));

        JLabel cardLabel = new JLabel("Enter Card Number: ");
        cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardNumberField = new JTextField();

        JLabel pinLabel = new JLabel("Enter PIN: ");
        pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinField = new JTextField();

        loginButton = createStyledButton("Login");
        registerButton = createStyledButton("Register ATM Card");
        insertCardButton = createStyledButton("Insert ATM Card");
        resetPinButton = createStyledButton("Reset PIN");

        panel.add(cardLabel);
        panel.add(cardNumberField);
        panel.add(pinLabel);
        panel.add(pinField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(insertCardButton);
        panel.add(resetPinButton);

        return panel;
    }

    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        balanceLabel = new JLabel("Balance: ");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        withdrawButton = createStyledButton("Withdraw");
        depositButton = createStyledButton("Deposit");
        balanceButton = createStyledButton("Check Balance");
        miniStatementButton = createStyledButton("Mini Statement");
        logoutButton = createStyledButton("Logout");

        panel.add(balanceLabel);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(balanceButton);
        panel.add(miniStatementButton);
        panel.add(logoutButton);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Register ATM Card":
                registerATMCard();
                break;
            case "Insert ATM Card":
                insertATMCard();
                break;
            case "Reset PIN":
                resetPIN();
                break;
            case "Login":
                login();
                break;
            case "Withdraw":
                withdraw();
                break;
            case "Deposit":
                deposit();
                break;
            case "Check Balance":
                checkBalance();
                break;
            case "Mini Statement":
                miniStatement();
                break;
            case "Logout":
                logout();
                break;
        }
    }

    private void registerATMCard() {
        JPanel registrationPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField accountNumberField = new JTextField();
        JTextField cardNumberField = new JTextField();
        JPasswordField pinField = new JPasswordField();

        registrationPanel.add(new JLabel("Account Holder Name:"));
        registrationPanel.add(nameField);
        registrationPanel.add(new JLabel("Account Number (5 digits):"));
        registrationPanel.add(accountNumberField);
        registrationPanel.add(new JLabel("Card Number (5 digits):"));
        registrationPanel.add(cardNumberField);
        registrationPanel.add(new JLabel("PIN (4 digits):"));
        registrationPanel.add(pinField);

        int result = JOptionPane.showConfirmDialog(this, registrationPanel, "Register ATM Card", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String accountNumber = accountNumberField.getText();
            String cardNumber = cardNumberField.getText();
            String pin = new String(pinField.getPassword());

            if (name.isEmpty() || accountNumber.isEmpty() || cardNumber.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
            } else if (!accountNumber.matches("\\d{5}")) {
                JOptionPane.showMessageDialog(this, "Account Number must be 5 digits!");
            } else if (!cardNumber.matches("\\d{5}")) {
                JOptionPane.showMessageDialog(this, "Card Number must be 5 digits!");
            } else if (!pin.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this, "PIN must be 4 digits!");
            } else if (atmCardData.containsKey(cardNumber)) {
                JOptionPane.showMessageDialog(this, "Card Number already exists!");
            } else {
                atmCardData.put(cardNumber, new User(name, accountNumber, pin));
                JOptionPane.showMessageDialog(this, "Card registered successfully!");
            }
        }
    }

    private void insertATMCard() {
        String enteredCardNumber = JOptionPane.showInputDialog("Enter ATM Card Number:");
        if (atmCardData.containsKey(enteredCardNumber)) {
            JOptionPane.showMessageDialog(this, "Card Found. Please Proceed!");
            isCardInserted = true; // Mark the card as inserted
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Card Number!");
        }
    }

    private void resetPIN() {
        String enteredCardNumber = JOptionPane.showInputDialog("Enter Card Number to Reset PIN:");
        if (!atmCardData.containsKey(enteredCardNumber)) {
            JOptionPane.showMessageDialog(this, "Card Number not found!");
            return;
        }

        String enteredOldPIN = JOptionPane.showInputDialog("Enter Old PIN:");
        User user = atmCardData.get(enteredCardNumber);

        if (!user.pin.equals(enteredOldPIN)) {
            JOptionPane.showMessageDialog(this, "Incorrect PIN!");
        } else {
            String newPIN = JOptionPane.showInputDialog("Enter New PIN (4 digits):");
            if (newPIN.matches("\\d{4}")) {
                user.pin = newPIN;
                JOptionPane.showMessageDialog(this, "PIN Reset Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "PIN must be 4 digits!");
            }
        }
    }

    private void login() {
        if (!isCardInserted) {
            JOptionPane.showMessageDialog(this, "Please insert your ATM card first!");
            return;
        }

        String cardNumber = cardNumberField.getText();
        String pin = pinField.getText();
        if (atmCardData.containsKey(cardNumber) && atmCardData.get(cardNumber).pin.equals(pin)) {
            currentCardNumber = cardNumber;
            balanceLabel.setText("Balance: " + atmCardData.get(cardNumber).balance);
            cardLayout.show(mainPanel, "Transaction");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Card Number or PIN!");
        }
    }

    private void withdraw() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if (amountStr != null) {
            int amount = Integer.parseInt(amountStr);
            User user = atmCardData.get(currentCardNumber);
            if (amount > user.balance) {
                JOptionPane.showMessageDialog(this, "Insufficient balance!");
            } else {
                user.balance -= amount;
                user.lastTransaction = "Withdraw";
                user.transactionDateTime = getCurrentDateTime();
                String transactionDetail = String.format("Withdraw: Rs %d on %s", amount, user.transactionDateTime);
                user.transactionHistory.addFirst(transactionDetail);
                if (user.transactionHistory.size() > 5) {
                    user.transactionHistory.removeLast();
                }
                balanceLabel.setText("Balance: " + user.balance);
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        }
    }

    private void deposit() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");

        if (amountStr != null) {
            int amount = Integer.parseInt(amountStr);
            User user = atmCardData.get(currentCardNumber);
            user.balance += amount;
            user.lastTransaction = "Deposit";
            user.transactionDateTime = getCurrentDateTime();
            String transactionDetail = String.format("Deposit: Rs %d on %s", amount, user.transactionDateTime);
            user.transactionHistory.addFirst(transactionDetail);
            if (user.transactionHistory.size() > 5) {
                user.transactionHistory.removeLast();
            }
            balanceLabel.setText("Balance: " + user.balance);
            JOptionPane.showMessageDialog(this, "Deposit successful!");
        }
    }

    private void checkBalance() {
        User user = atmCardData.get(currentCardNumber);
        JOptionPane.showMessageDialog(this, "Account Holder: "+user.name+"\n"+"Current Balance: Rs " + user.balance);
    }

    private void miniStatement() {
        User user = atmCardData.get(currentCardNumber);
        if (user.transactionHistory.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No transactions available!", "Mini Statement", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder miniStatement = new StringBuilder("Mini Statement:\n");
            miniStatement.append("Account Holder: ").append(user.name).append("\n");
            for (String transaction : user.transactionHistory) {
                miniStatement.append(transaction).append("\n");
            }
            JOptionPane.showMessageDialog(this, miniStatement.toString(), "Mini Statement", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void logout() {
        currentCardNumber = null;
        isCardInserted = false; // Reset card insertion status on logout
        cardLayout.show(mainPanel, "Login");
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMSystem atmSystem = new ATMSystem();
            atmSystem.setVisible(true);
        });
    }
}
