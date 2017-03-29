package Hashset;

import java.util.HashMap;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 2, 2, 1, 1, 4 };
		int val = 8;
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(obj.fractionToDecimal(0, 3));

	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder res = new StringBuilder();
		res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		res.append(num / den);
		res.append(".");
		num = num % den;
		if (num == 0)
			return res.toString();

		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, res.length());
		System.out.println(res.toString());
		while (num != 0) {
			num = num * 10;
			res.append(num / den);
			num = num % den;
			if (map.containsKey(num)) {
				res.insert(map.get(num), "(");
				res.append(")");
				break;
			} else
				map.put(num, res.length());

		}

		return res.toString();

	}

}
