import java.util.*;
import java.io.*;
class Exp7b{
    static double discount(int price, String cat){
        if(cat.equals("electronics"))return price*0.9;
        if(cat.equals("clothing"))return price*0.8;
        return price;
    }

    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter("Data_test.csv");
        pw.println("500,electronics");
        pw.println("300,clothing");
        pw.println("150,groceries");
        pw.close();

        BufferedReader br = new BufferedReader(new FileReader("Data_test.csv"));
        String line;

        while((line= br.readLine())!=null){
            String[] data = line.split(",");
            int price = Integer.parseInt(data[0]);
            String cat = data[1];
            System.out.printf("price: %d category = %s -> discounted = %.2f%n",price,cat,discount(price,cat));
        }
        br.close();

    }
}