import java.util.ArrayList;
import java.util.List;

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/
public class _17_LetterCombinationsofaPhoneNumber {
	String phone[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0)
			return res;
		String str = "";
		generate(digits, str, res);
		return res;
	}

	public void generate(String digits, String temp, List<String> list) {
		if (digits.length() < 1) {
			list.add(temp);
			return;
		}
		int curr = Character.getNumericValue(digits.charAt(0));
		int len = phone[curr].length();
		for (int i = 0; i < len; i++) {
			generate(digits.substring(1), temp + phone[curr].charAt(i), list);
		}
	}
}
