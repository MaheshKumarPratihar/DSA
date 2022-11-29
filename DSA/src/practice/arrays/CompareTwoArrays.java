package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import practice.arrays.resources.helpers.ReadTxtFile;

public class CompareTwoArrays {

	public static void main(String[] args) throws IOException {

		String fileName = "compareTwoArrays.txt";
		ReadTxtFile rtf = new ReadTxtFile(fileName);

		BufferedReader reader = rtf.readFile();

		String st;
		st = reader.readLine();

		int len = Integer.parseInt(st);

		String[] array_A = reader.readLine().split("\\s+");
		ArrayList<Long> arr_A = new ArrayList<>();
		Arrays.stream(array_A).forEach(x -> arr_A.add(Long.parseLong(x)));
		long[] A = arr_A.stream().mapToLong(Long::longValue).toArray();

		String[] array_B = reader.readLine().split("\\s+");
		ArrayList<Long> arr_B = new ArrayList<>();
		Arrays.stream(array_B).forEach(x -> arr_B.add(Long.parseLong(x)));
		long[] B = arr_B.stream().mapToLong(Long::longValue).toArray();

		if (check(A, B, len)) {
			System.out.println("Both arrays are equal");
		} else {
			System.out.println("Arrays are not equal");
		}

	}

	public static boolean check(long A[], long B[], int N) {
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < N; i++) {
			if (A[i] != B[i]) {
				return false;
			}
		}
		return true;
	}

}
