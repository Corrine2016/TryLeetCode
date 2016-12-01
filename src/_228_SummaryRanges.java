import java.util.ArrayList;
import java.util.List;

/*Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].*/

/**
 * @author corrine
 *
 */
public class _228_SummaryRanges {
	public static void main(String[] args) {
		int[] nums = new int[] {};
		System.out.println(summaryRanges(nums));
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> reStrings = new ArrayList<>();
		helper(reStrings, nums, 0);
		return reStrings;
	}

	private static void helper(List<String> reStrings, int[] nums, int start) {
		if (start >= nums.length)
			return;

		int j = 0;
		for (j = start + 1; j < nums.length; j++) {
			if (nums[j] != nums[j - 1] + 1)
				break;
		}

		String string = nums[start] + "->" + nums[j - 1];
		if (start == j - 1)
			string = nums[start] + "";
		reStrings.add(string);

		helper(reStrings, nums, j);
	}
}
