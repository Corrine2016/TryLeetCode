import java.util.Arrays;

/*Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.

Example 1:
Input: [1,2,3], [1,1]

Output: 1

Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:
Input: [1,2], [1,2,3]

Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.*/

//wenhui
public class _455_AssignCookies {
	public static void main(String[] args) {
		int[] g = new int[] { 10, 9, 8, 7 };
		int[] s = new int[] { 5, 6, 7, 8 };
		System.out.println(findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int childPos = 0;
		int cookiePos = 0;
		if (g.length == 0 || s.length == 0)
			return 0;
		return findCookie(childPos, cookiePos, g, s);

	}

	private static int findCookie(int childPos, int cookiePos, int[] g, int[] s) {
		int greed = g[childPos];
		while (cookiePos < s.length && s[cookiePos] < greed) {
			cookiePos++;
		}

		if (childPos < g.length - 1 && cookiePos < s.length - 1)
			return findCookie(childPos + 1, cookiePos + 1, g, s);
		else {
			if (cookiePos == s.length)
				return childPos;
			return childPos + 1;
		}

	}
}
