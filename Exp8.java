import java.util.*;
import java.io.*;
class Exp8{
    static double discount(int price, String cat){
        if(cat.equals("electronics"))return price*0.9;
        if(cat.equals("clothing"))return price*0.8;
        return price;
    }

    public static void main(String[] args) throws Exception{

        PrintWriter pw = new PrintWriter("batch_data.csv");
        pw.println("500,electronics,450");
        pw.println("300,clothing,240");
        pw.println("150,groceries,150");
        pw.println("1000,electronics,1000");
        pw.close();

        BufferedReader br = new BufferedReader(new FileReader("batch_data.csv"));
        String line;

        int pass = 0;
        int fail = 0;
        while((line=br.readLine())!=null){
            String[] data = line.split(",");
            int price = Integer.parseInt(data[0]);
            String cat = data[1];
            double exp = Double.parseDouble(data[2]);
            double act = discount(price,cat);
            
            if(exp ==act){
                System.out.println("PASS: " + cat + ", " + price);
                pass++;
            }
            else{
                System.out.println("FAIL: " + cat + ", " + price);
                fail++;
            }
        }
        br.close();
        System.out.println("PASS: " + pass + " FAIL:  " + fail);

    }
}