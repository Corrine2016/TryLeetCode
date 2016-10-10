
import java.util.HashMap;

//Given a roman numeral, convert it to an integer.
//Input is guaranteed to be within the range from 1 to 3999.
/*//基本字符：
 //
 //　　I、V、X、L、C、D、M
 //
 //　　相应的阿拉伯数字表示为：
 //
 //　　1、5、10、50、100、500、1000
 //
 //　　(1)相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 //
 //　　(2)小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 //
 //　　(3)小的数字，(限于Ⅰ、X 和C)在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 //
 //　　(4)正常使用时，连写的数字重复不得超过三次。(表盘上的四点钟“IIII”例外)
 //
 //　　(5)在一个数的上面画一条横线，表示这个数扩大1000倍。　　
 */

public class _13_RomantoInteger {
	public static void main(String[] args) {
		String string = "MMMMCMXCIX";
		System.out.println(romanToInt(string));
	}

	public static int romanToInt(String s) {
		int result = 0;
		HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
		numMap.put('I', 1);
		numMap.put('V', 5);
		numMap.put('X', 10);
		numMap.put('L', 50);
		numMap.put('C', 100);
		numMap.put('D', 500);
		numMap.put('M', 1000);
		char[] charArray = s.toCharArray();

		result = result + numMap.get(charArray[0]);
		for (int i = 1; i < charArray.length; i++) {

			if ((numMap.get(charArray[i]) == numMap.get(charArray[i - 1]))
					|| (numMap.get(charArray[i]) < numMap.get(charArray[i - 1]))) {
				result = result + numMap.get(charArray[i]);
			}
			if (numMap.get(charArray[i]) > numMap.get(charArray[i - 1])) {
				result = result + numMap.get(charArray[i]) - 2 * numMap.get(charArray[i - 1]);
			}

		}

		return result;

	}

}
