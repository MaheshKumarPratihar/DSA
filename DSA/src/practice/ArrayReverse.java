package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayReverse {

	public static void main(String[] args) {
		int size = 6;

		int[] arr = new int[] { 3, 2, 1, 56, 1000, 167 };

		int[] a = reverseArray(arr, size);
	}

	public static int[] reverseArray(int[] arr, int n) {

		if (n == 1) {
			return arr;
		}

//		ArrayList<Integer> a = Arrays.stream(arr).map(a -> a).collect(Collectors.toList());
//		ArrayList<Integer> a = (ArrayList<Integer>) Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
		

//		System.out.println(a);

//		return Arrays.stream(arr).Collectors.(toList());

		return arr;

	}
}
