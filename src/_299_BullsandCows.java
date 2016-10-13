import java.util.HashMap;

/*You are playing the following Bulls and Cows game with your friend: 
	You write down a number and ask your friend to guess what the number is.
	Each time your friend makes a guess, you provide a hint that indicates how many digits in said 
	guess match your secret number exactly in both digit and position (called "bulls") and how many 
	digits match the secret number but locate in the wrong position (called "cows"). Your friend will
	use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate
		the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function 
should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits,
and their lengths are always equal.*/
public class _299_BullsandCows {
	public static void main(String[] args) {
		String secret = "1234";
		String guess = "0111";
		System.out.println(getHint(secret, guess));
	}

	public static String getHint(String secret, String guess) {
		char[] chars1 = secret.toCharArray();
		char[] chars2 = guess.toCharArray();
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		int countA = 0;
		int countB = 0;

		for (int i = 0; i < chars1.length; i++) {
			if (chars1[i] == chars2[i])
				countA++;
			else {
				if (!map1.containsKey(chars1[i])) {
					map1.put(chars1[i], 1);
				} else {
					map1.put(chars1[i], map1.get(chars1[i]) + 1);
				}
				if (!map2.containsKey(chars2[i])) {
					map2.put(chars2[i], 1);
				} else {
					map2.put(chars2[i], map2.get(chars2[i]) + 1);
				}
			}

		}
		System.out.println(map1);
		System.out.println(map2);
		for (Character c : map2.keySet()) {
			if (map1.containsKey(c)) {
				countB = countB + Math.min(map1.get(c), map2.get(c));
			}

		}

		String result = countA + "A" + countB + "B";
		return result;
	}
}
