package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import practice.arrays.resources.helpers.ReadTxtFile;

/*Given array is sorted and of positive no. 
 * then find the index of K*/

public class BinarySearch {

	public static void main(String[] args) throws IOException {
		String fileName = "binarySearch.txt";
		ReadTxtFile rtf = new ReadTxtFile(fileName);

		BufferedReader br = rtf.readFile();

		String st;
		st = br.readLine();

		String[] info = st.split("\\s+");

		ArrayList<Integer> array = new ArrayList<>();

		int len = Integer.parseInt(info[0]);
		int K = Integer.parseInt(info[1]);
		while ((st = br.readLine()) != null) {
			String[] numbs = st.split("\\s+");
			Arrays.stream(numbs).forEach(x -> array.add(Integer.parseInt(x)));
		}

		int arr[] = new int[len];

		int i = 0;
		for (Integer intgr : array) {
			arr[i++] = intgr;
		}

		System.out.println(array);

		int index = binarysearch(arr, len, K);

		if (index == -1) {
			System.out.println(K + " is not present in the Arr");
		} else {
			System.out.println(K + " is present at index " + index);
		}

	}

	public static int binarysearch(int arr[], int n, int k) {

		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (arr[middle] == k) {
				return middle;
			} else if (arr[middle] < k) {
				left = middle + 1;
			} else if (arr[middle] > k) {
				right = middle - 1;
			}
		}

		return -1;
	}

}
