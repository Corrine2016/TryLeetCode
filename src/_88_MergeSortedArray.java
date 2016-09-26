//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
//The number of elements initialized in nums1 and nums2 are m and n respectively.
public class _88_MergeSortedArray {
	public static void test() {
		int[] nums1 = { 1, 2, 4, 8, 9, 11, 0, 0, 0, 0, 0 };

		int[] nums2 = { 3, 5, 6, 7, 10 };
		int n = nums2.length;
		int m = nums1.length - n;
		merge(nums1, m, nums2, n);
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];

		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				result[k] = nums1[i];
				i++;
			} else {
				result[k] = nums2[j];
				j++;
			}
			k++;
		}

		if (i < m) {
			System.arraycopy(nums1, i, result, k, m - i);

		}
		if (j < n) {
			System.arraycopy(nums2, j, result, k, n - j);
		}

		System.arraycopy(result, 0, nums1, 0, result.length);

	}
}
