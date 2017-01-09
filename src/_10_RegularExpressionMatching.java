/*Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true*/
//answer

public class _10_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		for (int i = 0; i < p.length(); s = s.substring(1)) {
			char c = p.charAt(i);
			if (i + 1 >= p.length() || p.charAt(i + 1) != '*')
				i++;
			else if (isMatch(s, p.substring(i + 2)))
				return true;

			if (s.isEmpty() || (c != '.' && c != s.charAt(0)))
				return false;
		}

		return s.isEmpty();
	}
}
