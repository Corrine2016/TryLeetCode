/*There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/

//wenhui
public class _134_GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		boolean res = false;
		for (int i = 0; i < gas.length; i++) {
			start = i;
			res = res || helper(start, gas, cost);
			if (res)
				return start;
		}
		return -1;
	}

	private boolean helper(int start, int[] gas, int[] cost) {
		int cur = 0;
		for (int i = 0; i < gas.length; i++) {
			int pos = (start + i) % gas.length;
			cur = cur + gas[pos];
			if (cur < cost[pos])
				return false;
			cur = cur - cost[pos];
		}
		return true;

	}
}
