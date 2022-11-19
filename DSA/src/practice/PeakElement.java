package practice;

import java.util.Arrays;

//An element is called a peak element 
//if its value is not smaller than the value of its adjacent elements(if they exists).
//Given an array arr[] of size N, Return the index of any one of its peak elements.
//Note: The generated output will always be 1 
//if the index that you return is correct. Otherwise output will be 0. 

public class PeakElement {

	public static void main(String[] args) {

		int size = 3;
		int[] intArray = new int[] { 1, 2, 3 };
		int result = peakElement(intArray, size);
		System.out.println("Given array is --> " + Arrays.toString(intArray));
		System.out.println("The peak element is " + result);

		int size_2 = 2;
		int[] intArray_2 = new int[] { 1, 13 };
		int result_2 = peakElement(intArray_2, size_2);
		System.out.println("Given array is --> " + Arrays.toString(intArray_2));
		System.out.println("The peak element is " + result_2);

		int size_3 = 4;
		int[] intArray_3 = new int[] { 1, 2, 2, 1 };
		int result_3 = peakElement(intArray_3, size_3);
		System.out.println("Given array is --> " + Arrays.toString(intArray_3));
		System.out.println("The peak element is " + result_3);

	}

	public static int peakElement(int[] arr, int n) {

		if (n == 2) {
			if (arr[0] >= arr[1]) {
				return 0;
			} else {
				return 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (arr[i + 1] <= arr[i]) {
					return i;
				}
				continue;
			}

			if (i == (n - 1)) {
				if (arr[n - 1] > arr[n - 2]) {
					return i;
				}
			}

			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
				return i;
			}
		}

		return 0;
	}

}
