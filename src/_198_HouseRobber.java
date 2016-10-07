//You are a professional robber planning to rob houses along a street.
//Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
//have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can 
//rob tonight without alerting the police.

/*http://blog.csdn.net/pistolove/article/details/47680663
 ˼·��
 ��1������������˼��������Ͳ�����������ˡ�����Ŀ����ת��Ϊͨ���׶�����ʽΪ������һ����������Arr����������������Ĳ�����Ԫ�صĺ͵����ֵ�����磺���������е�Ԫ��A1,A2,A3,A4������Ҫ�ж�A1+A3,A1+A4,A2+A4�е����ֵ��Ϊ����
 ��2��������һ���򵥶�̬�滮��ص���Ŀ������ܹ���ȷ���ҵ����еĵ��ƹ�ϵ����ô����ͺ������ˡ�����n���������飬���Ҫ���������������Ԫ�ص����ֵ����ô����ֻ�����n-1���������ֵ���Լ����n-2���������ֵ���ɣ��������γ����������������������ֵ���⣬
 ���Ժ����׿��ǳ����ƹ�ϵ����������ΪArr[]��n�����������Ӧ�Ĳ���������Ԫ�ص����ֵ�ú���f(n)��ʾ������f(n) = max{f(n-1), f(n-2)+A[n-1]}������n>=2��f(n)Ҳ��Ϊ���ƹ�ϵ������f(n-1)Ϊn-1��Ԫ�ص����ֵ��f(n-2)+Arr[n-1]Ϊn-2��Ԫ�ص����ֵ���������n��Ԫ�ص�ֵ��
 ��ΪҪ��Ԫ�ز������ڣ����Ի�������n-1��Ԫ�أ����Ӧ�úܺ���⡣�Զ�̬�滮����Ȥ��ͬѧ���Կ��������йض�̬�滮�����£����˾��ú��б�Ҫѧϰ��̬�滮��˼�롣*/
public class _198_HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] maxMoney = new int[len + 1];
		if (len == 1) {
			return nums[0];
		}
		maxMoney[1] = nums[0];
		maxMoney[2] = Math.max(nums[0], nums[1]);
		for (int i = 3; i < len + 1; i++) {
			maxMoney[i] = Math.max(maxMoney[i - 2] + nums[i - 1],
					maxMoney[i - 1]);
		}
		return maxMoney[len];
	}
}
