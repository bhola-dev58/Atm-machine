# ATM Operation Machine

This is a simple ATM system application built using Java Swing. The project provides a GUI-based simulation of an ATM machine that allows users to perform various banking operations.

## Features

- **User Registration**: Allows users to register a new ATM card with a unique card number, PIN, and account number.
- **ATM Card Insertion**: Simulates the insertion of an ATM card for further operations.
- **PIN Reset**: Enables users to reset their ATM PIN securely.
- **Login Functionality**: Provides secure login using card number and PIN.
- **Withdrawal**: Allows users to withdraw money from their account.
- **Deposit**: Enables users to deposit money into their account.
- **Balance Inquiry**: Displays the current balance of the user.
- **Mini Statement**: Provides a summary of the last five transactions.
- **Logout**: Securely logs out the user and resets the session.

## Prerequisites

- Java JDK 8 or later.
- IntelliJ IDEA (or any other Java IDE).
- Basic understanding of Java Swing for GUI development.

## Project Structure

- **`src/`**: Contains the source code for the ATM system application.
  - `ATMSystem.java`: Main file containing the implementation of the ATM system.


- **`Atm-Operation/`**: Contains the all file for the ATM system Project.
  - `out/production/Atm-Operation/`: Contains the all object file for the ATM system Project After compilation.
    - `ATMSystem.class`: Object file of class containing the implementation of the ATM system.
  - `src/`: Contains the source code for the ATM system application.
    - `ATMSystem.java`: Main file containing the implementation of the ATM system.
   
      
## Setup Instructions

<ol>
  <li>
    <strong>Clone the Repository</strong>
    <pre><code>git clone https://github.com/Bhya23cse/java-Projects.git
cd Atm-Operation</code></pre>
  </li>
  <li>
    <strong>Open the Project in IntelliJ IDEA</strong>
    <ul>
      <li>Open IntelliJ IDEA.</li>
      <li>Click on <strong>File > Open</strong> and select the folder where you cloned the project.</li>
    </ul>
  </li>
  <li>
    <strong>Run the Application</strong>
    <ul>
      <li>Open <strong>ATMSystem.java</strong> in the editor.</li>
      <li>Run the <strong>ATMSystem</strong> class by clicking on the green play button or pressing <strong>Shift + F10</strong>.</li>
    </ul>
  </li>
  <li>
    <strong>Using the Application</strong>
    <ul>
      <li><strong>Register an ATM Card</strong>: Click the "Register ATM Card" button and fill in the details.</li>
      <li><strong>Insert ATM Card</strong>: Enter the card number to proceed.</li>
      <li><strong>Login</strong>: Enter the card number and PIN to access your account.</li>
      <li><strong>Perform Transactions</strong>: Use the available buttons to withdraw, deposit, check balance, or view the mini-statement.</li>
      <li><strong>Logout</strong>: Click "Logout" to end the session.</li>
    </ul>
  </li>
</ol>

## Screenshots
<p>Add screenshots here to visually represent the application's GUI.</p>
<p>
<img align="centre" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/Home.png" style="width: 300px; height: 320px; display:flex;">

<img align="centre" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/register.png" style="width: 410px; height: 320px; display:flex;">

<img align="centre" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/insert%20atm.png" style="width: 370px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/atm%20found.png" style="width: 370px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/login.png" style="width: 300px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/Operatiopns.png" style="width: 300px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/amt%20to%20withdrawal.png" style="width: 300px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/amt%20deposit.png" style="width: 300px; height: 320px;">


<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/check%20balance.png" style="width: 300px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/mini%20statement.png" style="width: 300px; height: 320px;">

<img align="" src="https://github.com/Bhya23cse/java-Projects/blob/main/Atm-Operation/src/image/Home.png" style="width: 300px; height: 320px;">

</p>


## Possible Issues
<ul>
  <li><strong>Invalid Card Number or PIN</strong>: Ensure correct details during login or registration.</li>
  <li><strong>Insufficient Balance</strong>: Validate balance before withdrawing money.</li>
  <li><strong>Duplicate Card Number</strong>: Each card number must be unique during registration.</li>
</ul>

## Customization
<ul>
  <li>Modify the default balance by changing the value in the <strong>User</strong> constructor.</li>
  <li>Change the mini-statement size by adjusting the <strong>LinkedList</strong> capacity.</li>
  <li>Enhance the GUI with additional styling or components as needed.</li>
</ul>

## License
<p>This project is licensed under the <strong>MIT License</strong>.</p>
