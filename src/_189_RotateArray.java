//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
public class _189_RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int k = 1;
		rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void rotate(int[] nums, int k) {

		int[] temp = new int[nums.length];
		for (int i = 0; i < temp.length; i++) {
			temp[(i + k) % nums.length] = nums[i];
		}
		System.arraycopy(temp, 0, nums, 0, nums.length);

	}
}
