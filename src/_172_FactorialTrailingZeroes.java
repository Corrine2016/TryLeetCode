/*Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.*/

/*
 *172. Factorial Trailing Zeroes 
 *2016-6-4 by Mingyang
 * ���ȱ�����ʲô��factorial�����ǽ׳ˡ���ô�������뵽��Ҫͳ��
 * (2,5)�Եĸ�������Ϊ2��5=10�����������������һ�¾ͻᷢ����ʵֻҪ��5�ĸ����ͺ��ˣ�
 * ��Ϊ2ʵ���Ǳ�5Ҫ��Ķࡣ��ô�����Ŀ��ת����Ϊ�����1��n֮����������5��Լ�������ܺ͡�
 * �ܼ򵥵��뵽�ܲ�����n/5�õ������統nΪ19��ʱ��19/5 = 3.8����ô������3��Լ������5�������ֱ���5, 10,
 * 15�������е������ܱ�5������Σ�����˵25�� ��������һ�����ܸ�����factorial���׺ü���5��
 * ���Ľⷨ���Ƕ�n/5+n/25+n/125+��+������ͣ���nС�ڷ�ĸ��ʱ��ֹͣ����ĸ����Ϊ5^1, 5^2, 5^2��
 * �����Ļ��ڼ���5^2��ʱ���ܱ�25�����������������5������һ���Ѿ���5^1�м�����ˡ�����5^2ֱ�Ӽӵ�count�ϡ�
 */
public class _172_FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n < 0)
			return -1;
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
		return count;
	}
}
