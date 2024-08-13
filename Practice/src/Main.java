import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,7,8};
        System.out.println(returnSum(nums,0, nums.length));
    }
    static int sumAll = 0;
    public static int returnSum(int[] nums,int start , int end){

        int mid =(start+end)/2;
        if(nums.length == 1){
             sumAll+=nums[0];
        }
        return 0;
    }
}