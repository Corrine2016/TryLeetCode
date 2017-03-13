import java.util.ArrayList;
import java.util.List;

/*Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

 Example 1:
 Input: ["23:59","00:00"]
 Output: 1
 Note:
 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.*/

/**
 * @author Corrine
 *
 */
public class _539_MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		if (timePoints.size() == 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (String s : timePoints) {
			list.add(str2Int(s));
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		// Arrays.sort(array);
		// System.out.println(Arrays.toString(array));
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				min = Math.min(
						min,
						Math.min(Math.abs(array[j] - array[i]),
								1440 - Math.abs(array[j] - array[i])));
			}
		}
		return min;
	}

	private int str2Int(String s) {
		String hour = s.split(":")[0];
		String minute = s.split(":")[1];
		if (hour.startsWith("0"))
			hour.substring(1);
		if (minute.startsWith("0"))
			minute.substring(1);
		return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);

	}
}
