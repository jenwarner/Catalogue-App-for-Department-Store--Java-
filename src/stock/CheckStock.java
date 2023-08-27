package stock;
// The following lines of code imports various Java libraries into the class.
import java.awt.BorderLayout; // Imports the abstract windows toolkit class to enable use of the BorderLayout for GUI.
import java.awt.event.ActionListener; // Imports the event class residing in the abstract toolkit class to enable the use of the ActionListener.
import javax.swing.JFrame; // Imports the swing class to enable the JFrame component.
import javax.swing.JTextField; // Imports the swing class to enable the JTextField component.
import java.awt.TextArea; // Imports the abstract windows toolkit class to enable use of the TextArea.
import java.awt.event.ActionEvent; // Imports the event class residing in the abstract toolkit class to enable the use of the ActionEvent.
import java.text.DecimalFormat; // Imports the text class to enable the use of the DecimalFormat component.
import javax.swing.JButton; // Imports the swing class to enable the JButton component.
import javax.swing.JLabel; // Imports the swing class to enable the JLabel component.
import javax.swing.JPanel; // Imports the swing class to enable the JPanel component.

public class CheckStock extends JFrame implements ActionListener {

    JTextField stockNo = new JTextField(7); // Creates a text field named 'stockNo' which can hold 7 characters.
    TextArea information = new TextArea(3, 50); // Creates a text area named 'information' that can be 3 lines long and hold 50 characters.
    JButton check = new JButton("Check Stock"); // Creates a button named 'check' with the words "Check Stock" displayed on it.
    DecimalFormat pounds = new DecimalFormat("£#,##0.00"); // Formats any decimal number the program uses into the british pound locale.

    public CheckStock() { // Creates a constructor for the class.
        setLayout(new BorderLayout()); // Sets the Jframe to the border layout.
        setBounds(100, 100, 450, 150); // Sets the size of each section of the layout.
        setTitle("Check Stock"); // Changes the title of the window.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Disposes of this JFrame when the end user clicks the 'x' button displayed on the window's title frame.
        JPanel top = new JPanel(); // Creates a new instance of the JPanel named 'top'.
        top.add(new JLabel("Enter Stock Number:")); // Adds a label in the top JPanel.
        top.add(stockNo); // Adds the textfield named 'stockNo' to the JPanel named 'top'.
        top.add(check); // Adds the button named 'check' to the top JPanel.
        check.addActionListener(this); // Adds a listener for the button named 'check', which listens for the button being pressed.
        add("North", top); // Adds the top JPanel to the 'north' section of the border layout.
        JPanel middle = new JPanel(); // Creates a new instance of the JPanel named 'middle'.
        middle.add(information); // Adds the textarea named 'information' to the middle JPanel.
        add("Center", middle); // Adds the middle JPanel to the border layout in the 'center' position.

        setResizable(false); // Disables the user from resizing the window.
        setVisible(true); // Window is shown to user.
    }

    @Override // Overrides default method.
    public void actionPerformed(ActionEvent e) { 
        String key = stockNo.getText(); // Creates a String variable named 'key' and stores the user's input from the text field named 'stockNo'.
        String name = StockData.getName(key); // Tests the contents of the 'key' variable against the items contained in the StockData hashmap and stores it in a string variable named 'name'.
        if (name == null) {
            information.setText("No such item in stock"); // If the variable named 'name' is empty, the text area named 'information' will display the text "No such item in stock".
        } else { // If the variable 'name' does not contain an empty string, the following code will be executed.
            information.setText(name); // The text area named 'information' will display the contents of the 'name' variable.
            information.append("\nPrice: " + pounds.format(StockData.getPrice(key))); // The price of the item called by the end user will be formatted by the DecimalFormat class declared earlier in the code, and added to the 'information' text area on a new line.
            information.append("\nNumber in stock: " + StockData.getQuantity(key)); // The quantity of the item called by the end user will be displayed on an new line in the 'information' text area.
        }
    }
}
