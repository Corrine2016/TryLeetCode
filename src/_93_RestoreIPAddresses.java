import java.util.ArrayList;
import java.util.List;

/*Given a string containing only digits, restore it by returning all possible
valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
public class _93_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList();
		String[] address = new String[4];
		backtrack(result, 0, 0, s, address);
		return result;
	}

	private void backtrack(List<String> result, int start, int count, String input, String[] address) {
		if (count == 4) {
			if (start == input.length()) {
				// add new address
				StringBuilder sb = new StringBuilder();
				for (String s : address) {
					sb.append(s).append('.');
				}
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
			}
			return;
		}
		for (int index = start; index < start + 3 && index < input.length(); index++) {
			if (index > start && input.charAt(start) == '0') {
				break;
			}
			String toAdd = input.substring(start, index + 1);
			if (Integer.parseInt(toAdd) <= 255) {
				address[count] = toAdd;
				backtrack(result, index + 1, count + 1, input, address);
			}
		}
	}
}
