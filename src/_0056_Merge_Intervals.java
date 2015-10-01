
public class _0056_Merge_Intervals {

/*	Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].*/
	
	bool cmp(Interval a, Interval b) {
	    if (a.start != b.start) return a.start < b.start;
	    else return a.end < b.end;
	}

	class Solution {
	public:
	    vector<Interval> merge(vector<Interval> &intervals) {
	        if (intervals.size() < 2) return intervals;
	        
	        sort(intervals.begin(), intervals.end(), cmp);
	        intervals.push_back(Interval(99999999, 99999999 + 1));
	        vector<Interval> ans;
	        for (int i = 0; i < intervals.size() - 1; i++) {
	            if (intervals[i + 1].start <= intervals[i].end) {
	                intervals[i + 1].start = intervals[i].start;
	                if (intervals[i + 1].end < intervals[i].end) intervals[i + 1].end = intervals[i].end;
	            } else {
	                ans.push_back(intervals[i]);
	            }
	        }
	        intervals = ans;
	        return intervals;
	    }
	};
	
}
