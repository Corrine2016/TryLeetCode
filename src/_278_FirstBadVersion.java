/*You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after
a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.*/
public class _278_FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// given an API bool isBadVersion(version) which will return whether version
	// is bad.
	boolean isBadVersion(int version) {
		return true;
	}

	//// Time Limit Exceeded
	// public int firstBadVersion(int n) {
	// for(int i=1;i<=n;i++){
	// if(isBadVersion(i))
	// return i;
	// }
	// return 0;
	// }

	// Binary Search
	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
