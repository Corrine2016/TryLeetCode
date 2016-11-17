/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/
//http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
//http://blog.csdn.net/yutianzuijin/article/details/11499917
//https://discuss.leetcode.com/topic/64607/20-line-o-log-k-solution-with-clear-explanation-illustration/2
public class _4_MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		int k = totalLength / 2;
		if (totalLength % 2 == 0) {
			return (findKth(k + 1, nums1, nums2, 0, 0) + findKth(k, nums1, nums2, 0, 0)) / 2.0;
		} else {
			return findKth(k + 1, nums1, nums2, 0, 0);
		}
	}

	public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
		if (s1 >= nums1.length)
			return nums2[s2 + k - 1];
		if (s2 >= nums2.length)
			return nums1[s1 + k - 1];
		if (k == 1)
			return Math.min(nums1[s1], nums2[s2]);
		int m1 = s1 + k / 2 - 1, m2 = s2 + k / 2 - 1;
		int mid1 = m1 >= nums1.length ? Integer.MAX_VALUE : nums1[m1];
		int mid2 = m2 >= nums2.length ? Integer.MAX_VALUE : nums2[m2];
		if (mid1 > mid2)
			return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
		return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
	}
}
