package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import practice.arrays.resources.helpers.ReadTxtFile;

// ther array is sorted in first then rotated from one point.
public class SearchNumberInRotatedArray {

	public static void main(String[] args) throws IOException {
		String fileName = "rotatedArray.txt";
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

		System.out.println(array);
		int index = search(array, K);

		System.out.println("the element is at index --> " + index);
		
		int[] arr = array.stream().mapToInt(Integer::intValue).toArray();
		
		System.out.println("The minimum value in the Array is --> " + findMinInSortedRotatedArray(arr, len));

	}

	public static int search(final List<Integer> A, int B) {
		if (A.size() == 1 && A.get(0) == B) {
			return 0;
		}

		int n = A.size();
		int left = 0;
		int right = n - 1;

		int min = Integer.MAX_VALUE;
		int pivot_min = 0;
		while (left < right - 1) {
			int mid = (left + right) / 2;

			if (A.get(mid) > A.get(right)) {
				left = mid;
				if(right - left == 1) {
					if(A.get(right) < min) {
						min = A.get(right);
						pivot_min = right;
					}
					if(A.get(left) < min) {
						min = A.get(left);
						pivot_min = left;
					}
					break;
				}
				if (min > A.get(mid)) {
					min = A.get(mid);
				}
			} else if (A.get(mid) < A.get(right)) {
				right = mid;
				if (min > A.get(mid)) {
					min = A.get(mid);
					pivot_min = right;
				}
			}

		}

		left = 0;
		right = pivot_min - 1;
		
		if(pivot_min == n - 1) {
			if(A.get(pivot_min) == B) {
				return pivot_min;
			}
		}

		while (left <= right) {
			int middle = (left + right) / 2;

			if (A.get(middle) == B) {
				return middle;
			} else if (A.get(middle) < B) {
				left = middle + 1;
			} else if (A.get(middle) > B) {
				right = middle - 1;
			}
		}

		left = pivot_min;
		right = n - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (A.get(middle) == B) {
				return middle;
			} else if (A.get(middle) < B) {
				left = middle + 1;
			} else if (A.get(middle) > B) {
				right = middle - 1;
			}
		}

		return -1;
	}

	public static int findMinInSortedRotatedArray(int arr[], int n) {
		if (n == 1) {
			return arr[0];
		}

		if (n == 2) {
			if (arr[0] > arr[1])
				return arr[1];
			else
				return arr[0];
		}

		int left = 0;
		int right = n - 1;

		int min = Integer.MAX_VALUE;
		while (left <= right - 1) {
			int mid = (left + right) / 2;

			if (arr[mid] > arr[right]) {
				left = mid;
				if(right - left == 1) {
					if(arr[right] < min) {
						min = arr[right];
					}
					if(arr[left] < min) {
						min = arr[left];
					}
					break;
				}
				if (min > arr[mid]) {
					min = arr[mid];
				}
			} else if (arr[mid] < arr[right]) {
				right = mid;
				if (min > arr[mid]) {
					min = arr[mid];
				}
			}

		}

		return min;
	}

}
