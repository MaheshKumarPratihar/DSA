package practice.arrays;

import java.util.Arrays;

// need to find the Kth smallest element in below array we need 4th smallest element
// answer is 15
public class KthSmallestElement {

	public static void main(String[] args) {
		int length = 7;
		int arr[] = new int[] { 0, 7, 10, 4, 20, 15, -1 };
		int kthSmallestNumber = 1;
		int rs = kthSmallest(arr, 0, length - 1, kthSmallestNumber);

		System.out.println(kthSmallestNumber + "th smallest number is --> " + rs);

	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {

		Arrays.sort(arr);

		return arr[k - 1];
	}

}
