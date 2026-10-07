import java.util.*;

public class Exp7e{
    // static void addition(){
    //     try{
    //         assert 2+3 == 5;
    //         System.out.println("Add: PASS");
    //     }
    //     catch(Exception e){
    //         System.out.println("Add: FAIL");
    //     }
    // }

    // static void subtraction(){
    //     try{
    //         assert 3-2 == 5;
    //         System.out.println("Sub: PASS");
    //     }
    //     catch(AssertionError e){
    //         System.out.println("Sub: FAIL");
    //     }
    // }
     static void addition(){
        assert 2+3 == 5;
        System.out.println("Add: PASS");
    }

    static void subtraction(){
        assert 3-2 == 5;
        System.out.println("Sub: PASS");
    }

    public static void main(String[] args){
        addition();
        subtraction();
    }
}