import java.util.HashMap;

//Given a roman numeral, convert it to an integer.
//Input is guaranteed to be within the range from 1 to 3999.
/*//�����ַ���
//
//����I��V��X��L��C��D��M
//
//������Ӧ�İ��������ֱ�ʾΪ��
//
//����1��5��10��50��100��500��1000
//
//����(1)��ͬ��������д������ʾ����������Щ������ӵõ��������磺�� = 3��
//
//����(2)С�������ڴ�����ֵ��ұߣ�����ʾ����������Щ������ӵõ������� �磺�� = 8���� = 12��
//
//����(3)С�����֣�(���ڢ�X ��C)�ڴ�����ֵ���ߣ�����ʾ�������ڴ�����С���õ��������磺��= 4����= 9��
//
//����(4)����ʹ��ʱ����д�������ظ����ó������Ρ�(�����ϵ��ĵ��ӡ�IIII������)
//
//����(5)��һ���������滭һ�����ߣ���ʾ���������1000��������
*/
public class _13_RomantoInteger {
	public static void test() {
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
