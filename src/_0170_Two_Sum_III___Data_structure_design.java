
public class _0170_Two_Sum_III___Data_structure_design {

/*	Design and implement a TwoSum class. It should support the following operations: add and find.

	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.

	For example,
	add(1); add(3); add(5);
	find(4) -> true
	find(7) -> false*/
	
	class TwoSum {
	public:

	    unordered_multiset<int> m;

	    // Add the number to an internal data structure.
	    void add(int number) {
	        m.insert(number);
	    }

	    // Find if there exists any pair of numbers which sum is equal to the value.
	    bool find(int value) {
	        for (int i : m) {
	            int i2 = value - i;
	            if (i2 == i) {
	                if (m.count(i2) > 1) return true;
	            }
	            else {
	                if (m.count(i2) > 0) return true;
	            }
	        }
	        return false;
	    }
	};
	
}
