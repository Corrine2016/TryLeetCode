
/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author corrine
 *
 */
public class _57_InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		return merge(intervals);

	}

	static Comparator<Interval> comparator = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if (o1.start < o2.start)
				return -1;
			if (o1.start > o2.start)
				return 1;
			return 0;
		}

	};

	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, comparator);
		System.out.println(intervals);
		// for (int i = 0; i < intervals.size(); i++) {

		// System.out.println(intervals.get(i).start + " " +
		// intervals.get(i).end);
		// }
		if (intervals.size() < 2)
			return intervals;
		List<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= end && cur.end >= end)
				end = cur.end;
			else if (cur.start > end) {
				res.add(new Interval(start, end));
				start = cur.start;
				end = cur.end;
			}

		}
		System.out.println(start + " " + end);
		res.add(new Interval(start, end));
		return res;

	}
}
