/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author jenz_
 */
public class StockData1 {
    private static class Item {

        Item(int i, String n, String c, double p, int q) {
            id = 1;
            category = c;
            name = n;
            price = p;
            quantity = q;
        }

        // get methods
        public int getID() {
            return id;
        }
        public String getCategory() {
            return category;
        }
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        // instance variables 
        private String category, name;
        private double price;
        private int quantity, id;
    }
    public ArrayList<Item> item = new ArrayList<Item>();
     {
        item.add(new Item(00, "bin", "test", 50.00, 19));
    }
}
