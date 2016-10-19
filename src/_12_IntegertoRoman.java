/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/
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
 //����(5)��һ���������滭һ�����ߣ���ʾ���������1000������
  * 
  * ��(1)�������֢�X ��C �е��κ�һ�����������ù�����Ŀ�����߷��ڴ������ұ����ù�����Ŀ�������ܳ������������ڴ��������ֻ����һ����

����(2)���ܰѻ�������V ��L ��D �е��κ�һ����ΪС�����ڴ�������߲�������ķ���������Ŀ�����ڴ������ұ߲�����ӵķ�ʽ������Ŀ��ֻ��ʹ��һ����

����(3)V ��X ��ߵ�С����ֻ���â�

����(4)L ��C ��ߵ�С����ֻ����X��

����(5)D ��M ��ߵ�С����ֻ����C������
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
