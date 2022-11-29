package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import practice.arrays.resources.helpers.ReadTxtFile;

/*
Find out the maximum sub-array of non negative numbers from an array.

The sub-array should be contiguous i.e., a sub-array created by choosing 
the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. 
Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
a = [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.
If no such subarray is present return "-1"

*/
public class FindSubArray {

	public static void main(String[] args) throws IOException {
		String fileName = "findSubArray.txt";

		ReadTxtFile rtf = new ReadTxtFile(fileName);

		BufferedReader br = rtf.readFile();

		String st;
		st = br.readLine();

		String[] info = st.split("\\s+");

		int len = Integer.parseInt(info[0]);

		ArrayList<Integer> arr = new ArrayList<>();
		while ((st = br.readLine()) != null) {
			String[] numbs = st.split("\\s+");
			Arrays.stream(numbs).forEach(x -> arr.add(Integer.parseInt(x)));
		}

		int a[] = arr.stream().mapToInt(x -> x.intValue()).toArray();

		System.out.println("Resulting subArray is --> " + findSubarray(a, len));
	}

	public static ArrayList<Integer> findSubarray(int a[], int n) {
		int subArrayLen = 0;
		int subArraySum = 0;
		int subArrayInitialIndex = 0;

		int resSum = 0;
		int resSubArrayIndex = 0;
		int resSubArrayLen = 0;
		int resSubArrayLastIndex = 0;

		boolean hadPositiveNo = false;

		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				hadPositiveNo = true;
			}
			if (a[i] >= 0) {
				if (subArrayLen == 0) {
					subArrayInitialIndex = i;
				}
				subArrayLen++;
				subArraySum += a[i];
			} else if (subArrayLen != 0) {
				if (resSum < subArraySum) {
					resSum = subArraySum;
					resSubArrayIndex = subArrayInitialIndex;
					resSubArrayLastIndex = i - 1;
					resSubArrayLen = subArrayLen;
				} else if (resSum == subArraySum && resSubArrayLen < subArrayLen) {
					resSum = subArraySum;
					resSubArrayIndex = subArrayInitialIndex;
					resSubArrayLastIndex = i - 1;
					resSubArrayLen = subArrayLen;
				}
				subArrayLen = 0;
				subArraySum = 0;
			}
		}

		if (!hadPositiveNo) {
			ArrayList<Integer> rs = new ArrayList<Integer>();
			rs.add(-1);
			return rs;
		}

		if (subArrayLen != 0) {
			if (resSum < subArraySum) {
				resSum = subArraySum;
				resSubArrayIndex = subArrayInitialIndex;
				resSubArrayLastIndex = n - 1;
				resSubArrayLen = subArrayLen;
			} else if (resSum == subArraySum && resSubArrayLen < subArrayLen) {
				resSum = subArraySum;
				resSubArrayIndex = subArrayInitialIndex;
				resSubArrayLastIndex = n - 1;
				resSubArrayLen = subArrayLen;
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = resSubArrayIndex; i <= resSubArrayLastIndex && hadPositiveNo; i++) {
			res.add(a[i]);
		}

		return res;
	}

}
