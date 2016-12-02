/*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.*/
//https://discuss.leetcode.com/topic/31599/java-using-binary-indexed-tree-with-clear-explanation/2
/**
 * @author corrine
 *
 */
public class _307_RangeSumQuery {
}

class NumArray {

	private int[] nums2;

	public NumArray(int[] nums) {
		nums2 = new int[nums.length];
		System.arraycopy(nums, 0, nums2, 0, nums.length);
	}

	void update(int i, int val) {

		nums2[i] = val;

	}

	public int sumRange(int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum = sum + nums2[k];
		}
		return sum;
	}
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);