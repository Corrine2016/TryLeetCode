import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*Equations are given in the format A / B = k, where A and B are variables represented as strings, 
and k is a real number (floating point number). Given some queries, return the answers. 
		If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values,
vector<pair<string, string>> queries , where equations.size() == values.size(), 
and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result 
in no division by zero and there is no contradiction.*/
//answer
//https://discuss.leetcode.com/topic/58355/esay-understand-java-solution-3ms
public class _399_EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
		double[] result = new double[query.length];
		// filter unexpected words
		// 过滤掉没有遇见过的字符
		Set<String> words = new HashSet<>();
		for (String[] strs : equations) {
			words.add(strs[0]);
			words.add(strs[1]);
		}
		for (int i = 0; i < query.length; ++i) {
			String[] keys = query[i];
			if (!words.contains(keys[0]) || !words.contains(keys[1]))
				result[i] = -1.0d;
			else {
				Stack<Integer> stack = new Stack<>();
				result[i] = helper(equations, values, keys, stack);
			}
		}
		return result;
	}

	public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
		// 直接查找，key的顺序有正反
		// look up equations directly
		for (int i = 0; i < equations.length; ++i) {
			if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1]))
				return values[i];
			if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0]))
				return 1 / values[i];
		}
		// lookup equations by other equations
		// 间接查找，key的顺序也有正反
		for (int i = 0; i < equations.length; ++i) {
			if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
				stack.push(i);
				double temp = values[i] * helper(equations, values, new String[] { equations[i][1], keys[1] }, stack);
				if (temp > 0)
					return temp;
				else
					stack.pop();
			}
			if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
				stack.push(i);
				double temp = helper(equations, values, new String[] { equations[i][0], keys[1] }, stack) / values[i];
				if (temp > 0)
					return temp;
				else
					stack.pop();
			}
		}
		// 查不到，返回-1
		return -1.0d;
	}
}
