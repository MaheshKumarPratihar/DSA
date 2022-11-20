package practice.arrays;

// find the frequency of a number in an array
public class FindFrequency {

	public static void main(String[] args) {

		int number = 1;
		int arr[] = new int[] { 0, 1, 10, 1, 20, 1, -1 };

		int frequencyMethod_1 = findFrequencyMethod_1(arr, number);
		System.out.println("The frenquency of number " + number + " is --> " + frequencyMethod_1);

		int frequencyMethod_2 = findFrequencyMethod_2(arr, number);
		System.out.println("The frenquency of number " + number + " is --> " + frequencyMethod_2);

	}

//	time on https://practice.geeksforgeeks.org/problems/find-the-frequency/1 
//	time was ----> 0.38 sec, 0.37 sec, 0.29 sec
	public static int findFrequencyMethod_1(int A[], int x) {

		int count = 0;
		int length = A.length;
		for (int i = 0, j = length - 1; i < length && i <= j; i++, j--) {
			if (A[i] == x) {
				count++;
			}

			if (A[j] == x && i != j) {
				count++;
			}
		}

		return count;
	}

//  time on https://practice.geeksforgeeks.org/problems/find-the-frequency/1 
//	time was ----> 0.38 sec, 0.36 sec, 0.3 sec, 0.39 sec, 0.25 sec
	public static int findFrequencyMethod_2(int A[], int x) {
		int count = 0;
		int length = A.length;
		for (int i = 0; i < length; i++) {
			if (A[i] == x)
				count++;
		}
		return count;
	}

}
