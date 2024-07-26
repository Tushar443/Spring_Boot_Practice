import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class practice {
    public static void main(String[] a){
        Stack<Integer> s = new Stack();
        Stack<Integer> s2 = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        int i = 0 ;
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        System.out.println("print s1");
        s.forEach(n-> System.out.println(n));

        System.out.println("print s2");
        s2.forEach(n-> System.out.println(n));

    }
}
