import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] arr) {
        int a=10 ,b=20;
        Main.swap(a,b);
        System.out.println(a+" "+b);

        boolean x =true;
        if((x==true) || f(true)){
            System.out.println("C");
        }

        StringBuffer ar = new StringBuffer("A");
        StringBuffer brr = new StringBuffer("B");

        swapBuildeer(ar,brr);
        System.out.println(ar);
    }

    private static void swapBuildeer(StringBuffer ar, StringBuffer brr) {
        ar.append("B");
        ar=brr;
    }

    private static boolean f(boolean ll) {
        if (ll==true){
            System.out.println("B");
        }
        return ll;
    }

    public static void swap (int a ,int b){
        int temp = a;
        a =b;
        b=temp;
    }
}