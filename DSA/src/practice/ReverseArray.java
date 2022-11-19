package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {

	public static void Main(String args[]) {

		int size = 6;

		int[] arr = new int[] { 3, 2, 1, 56, 1000, 167 };

		int[] a = reverseArray(arr, size);

	}

	public static int[] reverseArray(int[] arr, int n) {

		if (n == 1) {
			return arr;
		}

		ArrayList<Integer> a = (ArrayList<Integer>) Arrays.stream(arr);

		System.out.println(a);

		return arr;

	}

}
