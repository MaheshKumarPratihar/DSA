package NegativeElementsToEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import practice.arrays.resources.helpers.ReadTxtFile;

public class NegativeElementsToEnd {

	public static void main(String[] args) throws IOException {

		String fileName = "NegativeElementsToEnd.txt";
		ReadTxtFile rtf = new ReadTxtFile(fileName);

		BufferedReader br = rtf.readFile();

		String st;
		st = br.readLine();

		String[] info = st.split("\\s+");

		ArrayList<Integer> array = new ArrayList<>();

		int len = Integer.parseInt(info[0]);
		while ((st = br.readLine()) != null) {
			String[] numbs = st.split("\\s+");
			Arrays.stream(numbs).forEach(x -> array.add(Integer.parseInt(x)));
		}

		int arr[] = new int[len];

		int i = 0;
		for (Integer intgr : array) {
			arr[i++] = intgr;
		}

		negativeElementsToEnd(arr, len);

		Arrays.stream(arr).boxed().forEach(System.out::println);

	}

	public static void negativeElementsToEnd(int[] arr, int length) {

		int middle = (length - 1) / 2;
		int count_ngtv = 0;

		for (int i = 0, j = length - 1; i <= middle && i <= j; i++, j--) {
			if (arr[i] < 0) {
				count_ngtv++;
			}
			if (arr[j] < 0 & i != j) {
				count_ngtv++;
			}
		}

		ArrayList<Integer> tmp = new ArrayList<Integer>();
//		tmp = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		for (Integer intgr : arr) {
			tmp.add(intgr);
		}

		int negStrtPos = length - count_ngtv;

		for (int i = 0, k = 0, j = negStrtPos; i < length; i++) {
			if (tmp.get(i) >= 0) {
				arr[k] = tmp.get(i);
				k++;
			} else {
				arr[j] = tmp.get(i);
				j++;
			}
		}
	}

}
