package practice.arrays.strings;

public class AddBinaryStrings {

	public static void main(String[] args) {
		String A = "1101";
		String B = "111";

		String res = addBinary(A, B);

		String ans = "10100";

		if (ans.equals(res)) {
			System.out.println("Our result is correct");
		} else {
			System.out.println("Our result isn't correct");
		}
	}

	public static String addBinary(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();

		int carry = 0;

		StringBuilder sb = new StringBuilder();

		if (lenA < lenB) {

			int dif = lenB - lenA;
			String extraZeroes = "";
			for (int i = 0; i < dif; i++) {
				extraZeroes = extraZeroes + "0";
			}
			extraZeroes = extraZeroes + A;
			A = extraZeroes.substring(0, extraZeroes.length());
		} else if (lenA > lenB) {
			int dif = lenA - lenB;
			String extraZeroes = "";
			for (int i = 0; i < dif; i++) {
				extraZeroes = extraZeroes + "0";
			}
			extraZeroes = extraZeroes + B;
			B = extraZeroes.substring(0, extraZeroes.length());
		}

		lenA = A.length();
		for (int i = lenA - 1; i >= 0; i--) {

			if (carry == 1) {
				if (A.charAt(i) == '1' && A.charAt(i) == B.charAt(i)) {
					sb.append("1");
					carry = 1;
				} else if (A.charAt(i) != B.charAt(i)) {
					carry = 1;
					sb.append("0");
				} else if (A.charAt(i) == '0' && A.charAt(i) == B.charAt(i)) {
					carry = 0;
					sb.append("1");
				}
			} else {
				if (A.charAt(i) == '1' && A.charAt(i) == B.charAt(i)) {
					sb.append("0");
					carry = 1;
				} else if (A.charAt(i) != B.charAt(i)) {
					carry = 0;
					sb.append("1");
				} else if (A.charAt(i) == '0' && A.charAt(i) == B.charAt(i)) {
					carry = 0;
					sb.append("0");
				}
			}

		}

		if (carry == 1) {
			sb.append("1");
		}

		sb = sb.reverse();
		int countZeroes = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '1') {
				break;
			}
			if (sb.charAt(i) == '0') {
				countZeroes++;
			}
		}

		sb.delete(0, countZeroes);
		return sb.toString();
	}

	private static int countZeroesAtEnd(String res) {
		int count = 0;
		int len = res.length();
		for (int i = len - 1; i >= 0; i--) {
			if (res.charAt(i) == '1') {
				return count;
			}
			if (res.charAt(i) == '0') {
				count++;
			}
		}
		return count;
	}

	public static void interchangeStrings(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		if (lenA > lenB) {
			return;
		} else {
			A = A + B;

			System.out.println("String A + B --> " + A);

			B = A.substring(0, (A.length() - B.length()));

			System.out.println("Extracted String B from A + B --> " + B);

			A = A.substring(B.length());

			System.out.println("Extracted String A from A + B --> " + A);
			return;
		}
	}

}
