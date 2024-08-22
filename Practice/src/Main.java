import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Array = { 10,20,20,25,63,63,10,25,10,78,85}
        //Sort the above array in ass order and remove the duplicate from it

        int[] arr= new int[]{ 10,20,20,25,63,63,10,25,10,78,85};
        //HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> set = new TreeSet<>(){
            @Override
            public Comparator<? super Integer> comparator() {
                return super.comparator();
            }
        };
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        set.forEach(System.out::println);
        //set.stream().sorted().forEach(System.out::println);
    }
}