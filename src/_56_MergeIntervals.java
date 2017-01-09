import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

/**
 * @author corrine
 *
 */
public class _56_MergeIntervals {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		System.out.println(intervals);
		merge(intervals);
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
