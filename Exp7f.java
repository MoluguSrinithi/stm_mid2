import java.util.*;
import java.io.*;
class Exp7f{
    static void test(int a, char c, int b, int exp){
        int res;
        if(c == '+')res = a+b;
        else if(c == '-')res = a-b;
        else res = a*b;

        String status = res==exp?"Pass":"Fail";
        System.out.printf("%d %c %d = %d(expected = %d) -> %s%n",a,c,b,res,exp,status);
    }

    public static void main(String[] args){
        int[][] data = {
            {2,3,'+',5},
            {3,3,'-',0},
            {2,3,'*',6},
            {2,3,'*',2}
        };
        for(int[] t: data){
            test(t[0],(char)t[2],t[1],t[3]);
        }
    }
}