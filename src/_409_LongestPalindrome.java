import java.util.HashMap;
import java.util.Iterator;

/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.*/
public class _409_LongestPalindrome {
	public static void main(String[] args) {
		System.out
				.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

	public static int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			if (!map.containsKey(key))
				map.put(key, 1);
			else {
				map.put(key, map.get(key) + 1);
			}
		}
		System.out.println(map);
		int result = 0;
		boolean isOdd = false;
		Iterator<Character> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			char key = iterator.next();
			if (map.get(key) % 2 == 1) {
				result += map.get(key) - 1;
				isOdd = true;
			}
			if (map.get(key) % 2 == 0)
				result += map.get(key);
		}
		if (isOdd == true)
			result++;
		return result;
	}
}
