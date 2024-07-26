
public class ClosestSorted {

	public static void main(String[] args) {
		int arr[] = {2,4,5,7,8,10,15,20};
		int k = 12;
		int len = arr.length;
		int left= 0,right =arr.length-1;
		
		int mid =0;
		
		while(left <= right) {
			mid = left+right/2;
			System.out.println("mid = "+ mid);
			if(arr[mid] < k) {
				left = mid+1;
				System.out.println("left = "+ left);
			}else if(arr[mid] > k){
				right = mid-1;
				System.out.println("right = "+ right);
			}else {
				System.out.println("Arr = "+ arr[mid]);
			}
			
		}

	}

}
