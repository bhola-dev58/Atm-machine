# Real-time-Charting-Box-Using-Java-Sockets


This is a simple real-time chat application built using Java with a server-client architecture. The project consists of two parts:

- **Server Side**: Handles incoming client connections and exchanges messages.
- **Client Side**: Connects to the server and participates in the chat.

## Features
- Real-time messaging between server and client.
- Simple GUI using Java's Swing framework.
- Message handling and display in both the client and server.
- Chat termination when either side sends the `"exit"` command.

## Prerequisites
- Java JDK 8 or later.
- IntelliJ IDEA (or any other Java IDE).
- Basic knowledge of networking in Java.

## Project Structure
- **`src/`**: Contains the source code for the server and client applications.
  - `Server.java`: Code for the server-side application.
  - `Client.java`: Code for the client-side application.

## Setup Instructions

### 1. Clone the Repository
`
git clone https://github.com/Bhya23cse/realtime-chat-java.git
cd realtime-chat-java`





 <h2>2. Open the Project in IntelliJ IDEA</h2>
    <ul>
        <li>Open IntelliJ IDEA.</li>
        <li>Click on <strong>File &gt; Open</strong> and select the folder where you cloned the project.</li>
    </ul>

   <h2>3. Run the Server</h2>
    <ul>
        <li>Open <code>Server.java</code> in the editor.</li>
        <li>Run the Server class by clicking on the green play button or pressing <code>Shift + F10</code>.</li>
        <li>The server will be waiting for client connections.</li>
    </ul>

   <h2>4. Run the Client</h2>
    <ul>
        <li>Open <code>Client.java</code> in the editor.</li>
        <li>Modify the IP address in the code to your server's IP (e.g., <code>"localhost"</code> or your network IP).</li>
        <li>Run the Client class similarly by clicking the play button or pressing <code>Shift + F10</code>.</li>
    </ul>

  <h2>5. Chatting</h2>
    <ul>
        <li>Once the client connects to the server, you can start typing messages in the text box.</li>
        <li>Press <code>Enter</code> to send messages.</li>
        <li>Type <code>"exit"</code> to terminate the chat from either side, both from the GUI and from the terminal/bash.</li>
    </ul>

   <h2>Exiting from Bash</h2>
    <ul>
        <li>If running the chat from the terminal, simply type <code>"exit"</code> and press <code>Enter</code> to close the connection and exit the chat.</li>
    </ul>

   <h2>Screenshots</h2>
   <img align="" src="https://github.com/Bhya23cse/Real-time-Charting-Box-Using-Java-Sockets/blob/main/src/pn.jpg">
 

  <h2>Possible Issues</h2>
    <ul>
        <li><strong>Port Already in Use:</strong> Ensure the port <code>8080</code> is free by checking if any other service is using it.</li>
        <li><strong>Firewall Blocking Connection:</strong> Allow Java through your firewall or disable the firewall temporarily.</li>
    </ul>

   <h2>Customization</h2>
    <ul>
        <li>You can change the port by modifying the <code>ServerSocket</code> initialization in the <code>Server.java</code> file.</li>
        <li>To connect multiple clients, consider implementing multi-threading on the server-side.</li>
    </ul>
