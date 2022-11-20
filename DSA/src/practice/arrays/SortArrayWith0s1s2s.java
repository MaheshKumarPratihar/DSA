package practice.arrays;

import java.util.Arrays;

public class SortArrayWith0s1s2s {
	public static void main(String[] args) {

		int length = 5;
		int a[] = new int[] { 0, 2, 1, 2, 0 };
//		sort012_v1(a, length);

		sort012_v2(a, length);
		Arrays.stream(a).forEach(System.out::println);

	}
// took 3 secs
	public static void sort012_v1(int a[], int n) {
		Arrays.sort(a);
	}

//	took 2.6 secs
	public static void sort012_v2(int a[], int n) {
		int count_0s = 0;
		int count_1s = 0;
		int count_2s = 0;

		int arr_length = a.length;

		int center = arr_length / 2;

		for (int i = 0, j = arr_length - 1; i <= center && i <= j; i++, j--) {

			if (a[i] == 0) {
				count_0s++;
			} else if (a[i] == 1) {
				count_1s++;
			}

			if (a[j] == 0 && i != j) {
				count_0s++;
			} else if (a[j] == 1 && i != j) {
				count_1s++;
			}

		}

		count_2s = arr_length - count_0s - count_1s;

		for (int i = 0, _0s, _1s, _2s; i < arr_length; i++) {
			if (i < count_0s) {
				a[i] = 0;
			} else if (i < count_1s + count_0s) {
				a[i] = 1;
			} else {
				a[i] = 2;
			}
		}

	}
}
