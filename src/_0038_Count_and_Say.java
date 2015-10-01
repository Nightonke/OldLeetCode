
public class _0038_Count_and_Say {

/*	The count-and-say sequence is the sequence of integers beginning as follows:
		1, 11, 21, 1211, 111221, ...

		1 is read off as "one 1" or 11.
		11 is read off as "two 1s" or 21.
		21 is read off as "one 2, then one 1" or 1211.
		Given an integer n, generate the nth sequence.

		Note: The sequence of integers will be represented as a string.*/
	
	class Solution {
	public:
	    string countAndSay(int n) {
	        string before = "1";
	        int counter = 1;
	        while(counter < n) {
	            counter++;
	            string next;
	            for (int i = 0; i < before.size(); i++) {
	                char temp = before[i];
	                int num = 1;
	                while (i + 1 < before.size() && before[i + 1] == temp) {
	                    num++;
	                    i++;
	                }
	                next += numToStr(num) + temp;
	            }
	            before = next;
	        }
	        return before;
	    }
	    string numToStr(int num) {
	        stringstream ss;
	        ss << num;
	        return ss.str();
	    }
	};
	
}
