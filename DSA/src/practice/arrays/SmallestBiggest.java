package practice.arrays;

public class SmallestBiggest {

	public static void main(String[] args) {
		int length = 7;
		int arr[] = new int[] { 0, 7, 10, 4, 20, 15, -1 };
		int[] rs = smallestBiggest(arr, 0, length - 1);

		System.out.println("The smallest number is --> " + rs[0]);
		System.out.println("The biggest number is --> " + rs[1]);

	}

	public static int[] smallestBiggest(int[] arr, int l, int r) {

		int center = (l + r) / 2;
		int smallest = Integer.MAX_VALUE;
		int biggest = Integer.MIN_VALUE;

		int i, j;
		for (i = 0, j = r; i <= center && i <= j; i++, j--) {
			if (arr[i] <= arr[j]) {
				if (arr[i] < smallest) {
					smallest = arr[i];
				}
				if (arr[j] > biggest) {
					biggest = arr[j];
				}
			} else {
				if (arr[j] < smallest) {
					smallest = arr[j];
				}
				if (arr[i] > biggest) {
					biggest = arr[i];
				}
			}
		}

		return new int[] { smallest, biggest };
	}
}
