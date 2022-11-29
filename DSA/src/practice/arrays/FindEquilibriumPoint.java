package practice.arrays;

import java.util.Arrays;

// sum of elements on left must be equal to elements on right of the eqb point
// eg 1 3 5 4 4 
// ans --> 5 as on left 1 + 3 = 4 = 2 + 2 on right so correct answer is position 3 means index 2 of element 5

public class FindEquilibriumPoint {

	public static void main(String[] args) {
		long arr[] = new long[] { 1, 1, 0, 0, 1 };
		
		System.out.println("Eqb point is --> " + equilibriumPoint(arr, arr.length));

	}

	public static int equilibriumPoint(long arr[], int n) {
		if (n == 1) {
			return 1;
		}
		
		long totalSum = Arrays.stream(arr).sum();
		
		long currentSum = arr[0];
		for(int i = 1; i < n; i++) {
			if(currentSum == (totalSum - arr[i] - currentSum)) {
				return i + 1;
			}
			
			currentSum += arr[i];
		}
		
		return -1;
	}

}
