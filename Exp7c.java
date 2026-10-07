import java.util.*;
import java.io.*;
import javax.swing.*;

class Exp7c{
    static double discount(int price, String cat){
        if(cat.equals("electronics"))return price*0.9;
        if(cat.equals("clothing"))return price*0.8;
        return price;
    }

    public static void main(String[] args) throws Exception{
        String[][] data = {
            {"500","electronics"},
            {"300","clothing"},
            {"150","groceries"}
        };
        String[] columns = {"price", "Category", "disc_price"};

        String[][] output = new String[3][3];

        for(int i = 0; i<3; i++){
            int price = Integer.parseInt(data[i][0]);
            String cat = data[i][1];
            output[i][0] = data[i][0];
            output[i][1] = data[i][1];
            output[i][2] = String.format("%.2f",discount(price,cat));
        }

        JTable table = new JTable(output,columns);
        JFrame frame = new JFrame("Data driven test");
        frame.add(new JScrollPane(table));
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}