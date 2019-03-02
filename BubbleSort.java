/******
 * 
 * Bubble Sort
 * O(n^2) time complexity - average case, worst case
 * O(n) time complexity - best case (because of the changes flag we can break out of the loop)
 * in-place sorting
 * 
 * ***********/

package programs;
import java.util.Arrays;

public class BubbleSort{

public static void swap(int[] arr, int a,int b){
int tmp = arr[a];
arr[a] = arr[b];
arr[b] = tmp;
}


public static int[] sort_bubble(int[] arr){
int n = arr.length;
boolean changes = false;
int iterations = 0;
for(int outer=0; outer<=n-2;outer++){
changes = false;
    for(int inner=0; inner<=n-2-outer; inner++){
    iterations++;
	if(arr[inner] > arr[inner+1]){
	swap(arr,inner,inner+1);
	changes = true;
	}
}
if(changes == false) break;
}
System.out.println("Number of iterations:"+iterations);
return arr;

}

public static void main(String[] args){

	int[] arr = {7,6,2,1,9};
	System.out.println(Arrays.toString(sort_bubble(arr)));
	
	int[] arr1 = {};
	System.out.println(Arrays.toString(sort_bubble(arr1)));
	
	int[] arr2 = {4,4,9,4,4,3};
	System.out.println(Arrays.toString(sort_bubble(arr2)));
	
	int[] arr3 = {17, 16, 11, 9, 7, 6, 2, 1};
	System.out.println(Arrays.toString(sort_bubble(arr3)));
}

}