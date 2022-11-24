package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import practice.arrays.resources.helpers.ReadTxtFile;

// find the left and right indexes of a subarray add up to number S
public class SumSubArray {

	public static void main(String[] args) throws IOException {

		int sum = 12;

		String fileName = "sumArrayInput.txt";

		ReadTxtFile rtf = new ReadTxtFile(fileName);

		BufferedReader br = rtf.readFile();

		String st;
		st = br.readLine();

		String[] info = st.split("\\s+");

		ArrayList<Integer> arr = new ArrayList<>();

		int len = Integer.parseInt(info[0]);
		int requiredSum = Integer.parseInt(info[1]);
		while ((st = br.readLine()) != null) {
			String[] numbs = st.split("\\s+");
			Arrays.stream(numbs).forEach(x -> arr.add(Integer.parseInt(x)));
		}

		ArrayList<Integer> res = subarraySum(arr, arr.size(), sum);

		System.out.println(res + " is the starting and ending of the subArray from array " + arr + " with size "
				+ arr.size() + '\n' + " whose sum is " + sum);

	}

	static ArrayList<Integer> subarraySum(ArrayList<Integer> arr, int n, int s) {
		int len = arr.size();

		ArrayList<Integer> res = new ArrayList<>();

		int sum = s;
		int currentSum = 0;
		for (int i = 0; i < len; i++) {
			currentSum = arr.get(i);
			for (int j = i + 1; currentSum <= sum && j < len; j++) {
				currentSum += arr.get(j);
				if (currentSum == sum) {
					res.add(i + 1);
					res.add(j + 1);
					return res;
				}
			}
			currentSum = 0;
		}

		res.add(-1);

		return res;
	}
}
