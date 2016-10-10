/*Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.*/
public class _223_RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int lowerBoundX = 0;
		int lowerBoundY = 0;

		int upperBoundX = 0;
		int upperBoundY = 0;

		if (A > G || B > H || C < E || D < F)
			return (D - B) * (C - A) + (H - F) * (G - E);

		lowerBoundX = (A > E) ? A : E;
		lowerBoundY = (B > F) ? B : F;

		upperBoundX = (C > G) ? G : C;
		upperBoundY = (D < H) ? D : H;

		return (D - B) * (C - A) + (H - F) * (G - E) - (upperBoundY - lowerBoundY) * (upperBoundX - lowerBoundX);

	}
}
