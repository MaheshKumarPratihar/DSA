package practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstElementKTimes {

	public static void main(String[] args) {
		int len = 7;
		int k = 2; // no. of times number should atleast occur
		int[] a = new int[] { 1, 7, 4, 3, 4, 8, 7 };

		System.out.println(frequencyMap(Arrays.stream(a).boxed()));

		int res = firstElementKTime(a, len, k);

		System.out.println("Our no. is -->  " + res);
	}

	public static int firstElementKTime(int[] a, int n, int k) {

		if (k == 1) {
			return a[0];
		}

		HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

		int count = 0;
		int posSum = 0;
		for (int i = 0; i < a.length; i++) {
			if (mp.get(a[i]) == null) {
				ArrayList<Integer> value = new ArrayList<Integer>();
				value.add(1); // count
				value.add(i); // posSum
				mp.put(a[i], value);
			} else {
				ArrayList<Integer> value = mp.get(a[i]);
				count = value.get(0);
				posSum = value.get(1);
				ArrayList<Integer> vl = new ArrayList<Integer>();
				vl.add(count + 1);
				vl.add(posSum + i);

				if (count + 1 == k) {
					return a[i];
				}

				mp.put(a[i], vl);
			}

		}
		return -1;
	}

	@SuppressWarnings("hiding")
	public static <Integer> Map<Integer, Long> frequencyMap(Stream<Integer> elements) {
		return elements
				.collect(Collectors.groupingBy(Function.identity(), () -> new TreeMap<>(), Collectors.counting()));
	}

}
