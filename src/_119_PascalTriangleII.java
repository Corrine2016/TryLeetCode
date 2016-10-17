import java.util.ArrayList;
import java.util.List;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?
public class _119_PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		int k = rowIndex + 1;
		int[] con = new int[k];
		con[0] = 1;
		for (int i = 1; i < k; i++) {
			con[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				con[j] = con[j - 1] + con[j];
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int kk : con)
			list.add(kk);
		return list;

	}

	// LeetCode尽量不写递归，也不满足空间要求
	// public static List<Integer> getRow(int rowIndex) {
	// List<Integer> list = new ArrayList<Integer>();
	// if (rowIndex == 0) {
	// list.add(1);
	// return list;
	// } else {
	// list.add(1);
	// for (int i = 1; i < rowIndex; i++) {
	// list.add(getRow(rowIndex - 1).get(i - 1) + getRow(rowIndex - 1).get(i));
	// }
	// list.add(1);
	// }
	//
	// return list;
	// }

	public static void main(String[] args) {

		List<Integer> list = getRow(4);
		System.out.println(list);

	}
}
