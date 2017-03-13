import java.util.LinkedList;

/*Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

 The number at the ith position is divisible by i.
 i is divisible by the number at the ith position.
 Now given N, how many beautiful arrangements can you construct?

 Example 1:
 Input: 2
 Output: 2
 Explanation: 

 The first beautiful arrangement is [1, 2]:

 Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

 The second beautiful arrangement is [2, 1]:

 Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 Note:
 N is a positive integer and will not exceed 15.*/

/**
 * @author Corrine
 *
 */
public class _526_BeautifulArrangement {
	public static void main(String[] args) {
		_526_BeautifulArrangement obj = new _526_BeautifulArrangement();
		obj.countArrangement(3);
	}

	public int countArrangement(int N) {
		LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		permutation(res, list, new LinkedList<Integer>());
		System.out.println(res);
		return res.size();
	}

	private void permutation(LinkedList<LinkedList<Integer>> res,
			LinkedList<Integer> list, LinkedList<Integer> temp) {
		if (temp.size() == list.size()) {
			res.addLast(new LinkedList<Integer>(temp));
		}
		for (int i = 0; i < list.size(); i++) {
			if (!temp.contains(list.get(i))
					&& (list.get(i) % (temp.size() + 1) == 0 || (temp.size() + 1)
							% list.get(i) == 0)) {
				temp.addLast(list.get(i));
				permutation(res, list, temp);
				temp.remove(list.get(i));
			}
		}

	}

}
