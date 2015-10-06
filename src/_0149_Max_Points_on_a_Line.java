
public class _0149_Max_Points_on_a_Line {

/*	Given n points on a 2D plane, find the maximum number of points that lie on 
 *  the same straight line.*/

	/**
	 * Definition for a point.
	 * struct Point {
	 *     int x;
	 *     int y;
	 *     Point() : x(0), y(0) {}
	 *     Point(int a, int b) : x(a), y(b) {}
	 * };
	 */
	class Solution {
	public:
	    int maxPoints(vector<Point> &points) {
	        if (points.size() == 0) {
	            return 0;
	        }
	        if (points.size() == 1) {
	            return 1;
	        }
	        if (points.size() == 2) {
	            return 2;
	        }
	        int max_num = 2;
	        for (int i = 0; i < points.size(); i++) {
	            for (int j = i + 1; j < points.size(); j++) {
	                if (points[i].x == points[j].x) {  // the slope does not exist
	                    int xx = points[i].x;
	                    int counter = 0;
	                    for (int q = 0; q < points.size(); q++) {
	                        if (points[q].x == xx) {
	                            counter++;
	                        }
	                    }
	                    if (counter > max_num) {
	                        max_num = counter;
	                    }
	                } else if (points[i].x != points[j].x) {
	                    int counter = 0;
	                    double k = (points[i].y * 1.0 - points[j].y) / (points[i].x * 1.0 - points[j].x);
	                    double b = points[i].y - k * points[i].x;
	                    for (int q = 0; q < points.size(); q++) {
	                        double error = points[q].y - k * points[q].x - b;
	                        if (-0.001 <= error && error <= 0.001) {
	                            counter++;
	                        }
	                    }
	                    if (counter > max_num) {
	                        max_num = counter;
	                    }
	                }
	            }
	        }
	        return max_num;
	    }
	};
	
}
