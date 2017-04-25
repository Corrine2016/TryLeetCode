package hashset;
import java.util.HashSet;

//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer,
//replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
//or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1

/**
 * @author Corrine
 *
 */
public class _202_HappyNumber {
	HashSet<Integer> set = new HashSet<Integer>();

	public boolean isHappy(int n) {

		if (set.contains(n))
			return false;
		else if (getSum(n) == 1)
			return true;

		else {
			set.add(n);
			return isHappy(getSum(n));
		}

	}

	private int getSum(int n) {
		String s = "" + n;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = Integer.parseInt(s.charAt(i) + "");
			sum += cur * cur;
		}
		return sum;
	}
}
