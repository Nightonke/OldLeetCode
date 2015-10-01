
public class _0057_Insert_Interval {

/*	Given a set of non-overlapping intervals, insert a new interval into the 
 *  intervals (merge if necessary).

	You may assume that the intervals were initially sorted according to their 
	start times.

	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],
	[3,10],[12,16].

	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/
	
	class Solution {
	public:
	    void include(vector<Interval> &intervals, int target, int & l, int & r, bool & isIncluded) {
	        for (int i = 0; i < intervals.size(); i++) {
	            if (target < intervals[i].start) {
	                l = i - 1;
	                r = i;
	                isIncluded = false;
	                return;
	            } else if (intervals[i].start <= target && target <= intervals[i].end) {
	                l = r = i;
	                isIncluded = true;
	                return;
	            }
	        }
	        l = intervals.size() - 1;
	        r = intervals.size();
	        isIncluded = false;
	    }
	    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
	        vector<Interval> ans;
	        int sl, sr, el, er;
	        bool si, ei;
	        include(intervals, newInterval.start, sl, sr, si);
	        include(intervals, newInterval.end, el, er, ei);
	        if (si && ei) {
	            for (int i = 0; i < intervals.size(); i++) {
	                if (i == sl) {
	                    Interval newinter(intervals[sl].start, intervals[er].end);
	                    ans.push_back(newinter);
	                    i = er;
	                } else {
	                    ans.push_back(intervals[i]);
	                }
	            }
	        } else if (si && !ei) {
	            for (int i = 0; i < intervals.size(); i++) {
	                if (i == sl) {
	                    Interval newinter(intervals[i].start, newInterval.end);
	                    ans.push_back(newinter);
	                    i = el;
	                } else {
	                    ans.push_back(intervals[i]);
	                }
	            }
	        } else if (!si && ei) {
	            for (int i = 0; i < intervals.size(); i++) {
	                if (i == sr) {
	                    Interval newinter(newInterval.start, intervals[er].end);
	                    ans.push_back(newinter);
	                    i = er;
	                } else {
	                    ans.push_back(intervals[i]);
	                }
	            }
	        } else {
	            if (sr == intervals.size()) {
	                ans = intervals;
	                ans.push_back(Interval(newInterval.start, newInterval.end));
	                return ans;
	            }
	            if (er == 0) {
	                ans.push_back(Interval(newInterval.start, newInterval.end));
	                for (int i = 0; i < intervals.size(); i++) ans.push_back(intervals[i]);
	                return ans;
	            }
	            if (sl == el && sr == er) {
	                for (int i = 0; i < er; i++) ans.push_back(intervals[i]);
	                ans.push_back(Interval(newInterval.start, newInterval.end));
	                for (int i = er; i < intervals.size(); i++) ans.push_back(intervals[i]);
	                return ans;
	            }
	            for (int i = 0; i < intervals.size(); i++) {
	                if (i == sr) {
	                    Interval newinter(newInterval.start, newInterval.end);
	                    ans.push_back(newinter);
	                    i = el;
	                } else {
	                    ans.push_back(intervals[i]);
	                }
	            }
	        }
	        return ans;
	    }
	};

}
