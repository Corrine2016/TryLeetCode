
//Implement atoi to convert a string to an integer.
//
//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.*/
////�жϿ�ͷ�������ţ��ж��Ƿ�Ϊ�գ��ж��Ƿ񳬹�int��Χ,ȥ���ո�,ȥ��������ĸ����ַ�����"  -0012a42"->"-12"
//һ��atoi()�������ַ���ת����������
//���㣺�ַ���ת��Ϊ����ʱ�������ASCII�����⡣
// 
//Cʵ�֣�
//#include <ctype.h>
//#include <stdio.h>
//int atoi (char s[]);
//int main(void )
//{
//char s[100];
//gets(s);s
//printf("integer=%d\n",atoi(s));
//return 0;
//}
//int atoi (char s[])
//{
//int i,n,sign;
//for(i=0;isspace(s[i]);i++)//�����հ׷�;
//sign=(s[i]=='-')?-1:1;
//if(s[i]=='+'||s[i]==' -')//��������
//  i++;
//for(n=0;isdigit(s[i]);i++)
//       n=10*n+(s[i]-'0');//�������ַ�ת������������
//return sign *n;
//}

public class _8_StringtoInteger {
	public static void test() {
		String s = "  -0012a42";
		System.out.println(myAtoi(s));

	}

	public static int myAtoi(String str) {

		double result = 0;
		int POrN = 1;
		int count = 0;
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			count++;
			if (c >= '0' && c <= '9') {
				result *= 10;
				result += (c - '0');
			} else if (c == '-' && count == 1) {
				POrN = -1;
			} else if (c == '+' && count == 1) {
				POrN = 1;
			} else if (c == ' ' && count == 1) {
				count--;
			} else {
				break;
			}

		}
		if (result > Integer.MAX_VALUE) {
			if (POrN == 1)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		} else {
			return (int) (result * POrN);
		}
	}
}
