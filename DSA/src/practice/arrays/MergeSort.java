package practice.arrays;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int length = 7;
		int mainArray[] = new int[] { 23, 235, 63, 73, 11, 0, -1 };

		System.out.println("Method 1");
		System.out.println("Initial Array ---> ");
		Arrays.stream(mainArray).forEach(x -> System.out.println(x));

		mergeSort(mainArray, length);
		System.out.println("Sorted Array ---> ");
		Arrays.stream(mainArray).forEach(x -> System.out.println(x));
		System.out.println('\n');
		System.out.println('\n' + "Method 2");

		int mainArray_2[] = new int[] { 2, 25, 3, -3, 10, 0, -1 };
		System.out.println("Initial Array ---> ");
		Arrays.stream(mainArray_2).forEach(x -> System.out.println(x));

		sort(mainArray_2, 0, length - 1);
		System.out.println("Sorted Array ---> ");
		Arrays.stream(mainArray_2).forEach(x -> System.out.println(x));
	}

	public static <B> void mergeSort(int[] mainArray, int length) {

		int left = 0;
		int right = length - 1;

		int tempArray[] = new int[length];

		merge_sort_r(mainArray, tempArray, left, right);
	}

//	 this function helps in diving the array in two halves by calling recursively itself
//	Untill one element is left then call merge to merge them again.
	public static void merge_sort_r(int[] A, int[] B, int left, int right) {
//	    center is center of array which helps in become right of left
//		array and center + 1 becomes start of right array in recursive call
//		of merge_sort_r
		int center;

		if (right <= left) { // if right > left means still array is not equal to 1 element
			return;
		}

		center = (left + right) / 2; // this will give us the center index

		merge_sort_r(A, B, left, center);
		merge_sort_r(A, B, center + 1, right);

		merge(A, B, left, center, right);

	}

//	this function helps in merging the divided arrays but with merging 
//	it also sorts them too.
	public static void merge(int[] A, int[] B, int left, int center, int right) {

		int i, j, k;

		for (i = left, j = center + 1, k = left; i <= center && j <= right;) {
			if (A[i] <= A[j]) {
				B[k++] = A[i++];
			} else {
				B[k++] = A[j++];
			}

		}

		while (i <= center) {
			B[k++] = A[i++];
		}

		while (j <= right) {
			B[k++] = A[j++];
		}

		for (i = 0; i <= right; i++) {
			A[i] = B[i];
		}

		return;
	}

	public static void sort(int arr[], int left, int right) {
		if (left < right) {
			// find the middle point
			int center = (left + (right - 1)) / 2;

			// Sort first and second halves
			sort(arr, left, center);
			sort(arr, center + 1, right);

			// Merge the sorted halves
			merge_v2(arr, left, center, right);
		}
	}

	public static void merge_v2(int arr[], int left, int center, int right) {
		// size of two subarrays to be merged
		int n1 = center - left + 1;
		int n2 = right - center;

		/* Create temp arrays */
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}

		for (int j = 0; j < n2; j++) {
			rightArray[j] = arr[center + 1 + j];
		}

		/* merge the temp arrays */
		int i = 0, j = 0, k = left;
		for (; i < n1 && j < n2;) {
			if (leftArray[i] <= rightArray[i]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}

}
