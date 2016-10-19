/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/
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
  * 
  * 　(1)基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；放在大数的左边只能用一个。

　　(2)不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目，只能使用一个。

　　(3)V 和X 左边的小数字只能用Ⅰ。

　　(4)L 和C 左边的小数字只能用X。

　　(5)D 和M 左边的小数字只能用C。　　
 */
public class _12_IntegertoRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(9));

	}

	public static String intToRoman(int num) {
		String result = "";
		int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };
		char[] chars = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		for (int i = numbers.length - 1; i >= 0; i--) {

			int temp = num / numbers[i];
			if (temp == 4)
				result = result + chars[i] + chars[i + 1];
			else {
				for (int j = 0; j < temp; j++) {

					result = result + chars[i];
				}
			}
			num = num - temp * numbers[i];
		}
		System.out.println(result);
		result = result.replace("VIV", "IX");
		result = result.replace("LXL", "XC");
		result = result.replace("DCD", "CM");
		return result;
	}
}
