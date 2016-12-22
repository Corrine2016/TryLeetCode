import java.util.Random;

/*Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);*/
//answer
//382 水库抽样
public class _398_RandomPickIndex {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 3, 3 };
		Solution4 obj = new Solution4(nums);
		int param_1 = obj.pick(3);
		System.out.println(param_1);
	}

}

class Solution4 {
	int[] nums;
	Random random = new Random();

	public Solution4(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		int count = 0;
		int res = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			else {
				if (random.nextInt(++count) == 0)
					res = i;
			}

		}
		return res;

	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */