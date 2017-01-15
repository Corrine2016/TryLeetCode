import java.util.HashMap;

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//answer
public class _149_MaxPointsonaLine {

	/*
	 * A line is determined by two factors,say y=ax+b
	 * 
	 * If two points(x1,y1) (x2,y2) are on the same line(Of course).
	 * 
	 * Consider the gap between two points.
	 * 
	 * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled
	 * since b is a constant
	 * 
	 * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
	 * 
	 * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
	 * 
	 * Since a is a rational, there exists y0 and x0,
	 * y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
	 * 
	 * So we can use y0&x0 to track a line;
	 */

	public int maxPoints(Point[] points) {
		if (points.length <= 0)
			return 0;
		if (points.length <= 2)
			return points.length;
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
			int samex = 1;
			int samep = 0;
			for (int j = 0; j < points.length; j++) {
				if (j != i) {
					if ((points[j].x == points[i].x)
							&& (points[j].y == points[i].y)) {
						samep++;
					}
					if (points[j].x == points[i].x) {
						samex++;
						continue;
					}
					double k = (double) (points[j].y - points[i].y)
							/ (double) (points[j].x - points[i].x);
					if (hm.containsKey(k)) {
						hm.put(k, hm.get(k) + 1);
					} else {
						hm.put(k, 2);
					}
					result = Math.max(result, hm.get(k) + samep);
				}
			}
			result = Math.max(result, samex);
		}
		return result;
	}
}