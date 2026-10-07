import java.util.*;
import java.io.*;
class Exp7a{
    static double discount(int price, String cat){
        if(cat.equals("electronics"))return price*0.9;
        if(cat.equals("clothing"))return price*0.8;
        return price;
    }

    public static void main(String[] args){
        String []categories = {"electronics", "clothing", "groceries"};
        Random r = new Random();

        for(int i = 1; i<=5; i++){
            int price = 100+r.nextInt(901);
            String cat = categories[r.nextInt(3)];
            System.out.printf("Test %d price: %d category %s -> discount = %.2f%n",i,price,cat,discount(price,cat));
        }
    }
}