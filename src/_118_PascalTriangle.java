import java.util.ArrayList;
import java.util.List;

//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class _118_PascalTriangle {
	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = generate(numRows);
		System.out.println(result);

	}

	static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static List<List<Integer>> generate(int numRows) {

		for (int i = 0; i < numRows; i++) {

			result.add(generateRow(i));
		}

		return result;
	}

	private static List<Integer> generateRow(int num) {
		List<Integer> list = new ArrayList<Integer>();
		if (num == 0) {
			list.add(1);
			return list;
		} else {
			list.add(1);
			for (int i = 1; i < num; i++) {

				list.add(result.get(num - 1).get(i - 1)
						+ result.get(num - 1).get(i));

			}
			list.add(1);
		}

		return list;
	}
}
