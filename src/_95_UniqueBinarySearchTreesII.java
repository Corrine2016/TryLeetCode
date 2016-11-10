/*Given an integer n, generate all structurally unique BST's (binary search trees)
that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

//https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
public class _95_UniqueBinarySearchTreesII {
	public int numTrees(int n) {
		int t[] = new int[n + 1];
		t[0] = 1;
		for (int i = 1; i <= n; ++i)
			for (int j = 1; j <= i; ++j)
				t[i] += t[j - 1] * t[i - j];
		return t[n];
	}

}
