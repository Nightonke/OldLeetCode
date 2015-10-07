
public class _0223_Rectangle_Area {

/*	Find the total area covered by two rectilinear rectangles in a 2D plane.

	Each rectangle is defined by its bottom left corner and top right corner 
	as shown in the figure.

	Rectangle Area
	Assume that the total area is never beyond the maximum possible value of 
	int.*/
	
	#define min(A, B) (A > B ? B : A)
	#define max(A, B) (A > B ? A : B)

	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	    int a = max(A, E), b = max(B, F), c = min(C, G), d = min(D, H);
	    return (C - A) * (D - B) + (G - E) * (H - F) - ((a < c && b < d) ? (c - a) * (d - b) : 0);
	}
	
}
