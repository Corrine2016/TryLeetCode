import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
*/

/**
 * @author corrine
 *
 */
public class _506_RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
		List<Integer> myList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(myList);
		Collections.reverse(myList);
		System.out.println(myList);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(myList.get(i), i);
		}
		String[] reStrings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {

			int temp = map.get(nums[i]) + 1;
			if (temp == 1)
				reStrings[i] = "Gold Medal";
			else if (temp == 2)
				reStrings[i] = "Silver Medal";
			else if (temp == 3)
				reStrings[i] = "Bronze Medal";
			else
				reStrings[i] = "" + temp;
		}
		return reStrings;

	}
}
