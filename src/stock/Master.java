package stock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Master extends JFrame implements ActionListener {

    JButton check = new JButton("Check Stock");
    JButton purchase = new JButton("Purchase Item");
    JButton stock = new JButton("Update Stock");
    JButton quit = new JButton("Exit");

    public static void main(String[] args) {
        Master master = new Master();
    }

    public Master() {
        setLayout(new BorderLayout());
        setSize(450, 100);
        setTitle("Store");

        // close application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JLabel("Select an option by clicking one of the buttons below"));
        add("North", top);

        JPanel bottom = new JPanel();
        bottom.add(check);
        check.addActionListener(this);
        bottom.add(purchase);
        purchase.addActionListener(this);
        bottom.add(stock);
        stock.addActionListener(this);
        bottom.add(quit);
        quit.addActionListener(this);
        add("South", bottom);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            CheckStock checkStock = new CheckStock();
        } else if (e.getSource() == purchase) {
        PurchaseItem purchaseItem = new PurchaseItem();
        } else if (e.getSource() == stock) {
            this.setVisible(false);
            EmployeeLogin employeeLogin = new EmployeeLogin();
            employeeLogin.setVisible(true);
            //UpdateStock updateStock = new UpdateStock();
        }else if (e.getSource() == quit) {
            StockData.close();
            System.exit(0);
        }
    }
}
