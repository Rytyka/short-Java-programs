/******
 * 
 * Selection Sort
 * O(n^2) time complexity
 * O(n) space complexity (in place sorting)
 * 
 * ***********/


package programs;
import java.util.Arrays;
public class SelectionSort {
	public static int[] sort_selection(int[] arr){
		int n= arr.length;
		for(int outer=0; outer<=n-2;outer++){
			int min= outer;
			for(int inner = outer+1; inner<=n-1;inner++){
			if(arr[inner] < arr[min]){
			min = inner;
			}
			}
		int tmp = arr[outer];
		arr[outer] = arr[min];
		arr[min] = tmp;
		System.out.println(Arrays.toString(arr));
		}

		return arr;
		}
		public static void main(String[] args){

		int[] array = {5, 7, 9, 3, 10, 0};
		//sort_selection(array);
		System.out.println(Arrays.toString(sort_selection(array)));

		}

}
