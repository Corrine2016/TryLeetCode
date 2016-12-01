/*
 Follow up for H-Index: What if the citations array is sorted in ascending order? 
		Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.*/

/**
 * @author corrine
 *
 */
public class _275_HIndexII {
	public int hIndex(int[] citations) {

		int h = 0;
		for (; h < citations.length; h++) {
			if (citations[h] >= citations.length - h)
				break;
		}
		return citations.length - h;
	}
}
