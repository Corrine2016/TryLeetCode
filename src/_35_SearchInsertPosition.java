/*Given a sorted array and a target value, return the index if the target is found. If not, 
 * return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0*/
public class _35_SearchInsertPosition {
	public static void main(String[] args) {
		int[] a = { 1, 3 };
		System.out.println(searchInsert(a, 2));
	}

	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

	// public int searchInsert(int[] nums, int target) {
	// int low = 0, high = nums.length - 1,mid = 0;
	// while(low <= high){
	// mid = low+(high-low) / 2;
	// if(nums[mid] == target) {
	// return mid;
	// }else if(nums[mid] > target){
	// high = mid - 1;
	// }else{
	// low = mid + 1;
	// }
	// }
	//
	//
	// return low;
	//
	// }
}
