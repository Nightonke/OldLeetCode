
public class _0068_Text_Justification {

/*	Given an array of words and a length L, format the text such that each line 
 *  has exactly L characters and is fully (left and right) justified.

	You should pack your words in a greedy approach; that is, pack as many words 
	as you can in each line. Pad extra spaces ' ' when necessary so that each 
	line has exactly L characters.

	Extra spaces between words should be distributed as evenly as possible. If 
	the number of spaces on a line do not divide evenly between words, the empty 
	slots on the left will be assigned more spaces than the slots on the right.

	For the last line of text, it should be left justified and no extra space is 
	inserted between words.

	For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.

	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	Note: Each word is guaranteed not to exceed L in length.

	click to show corner cases.*/
	
	class Solution {
	    //try insert as many as words in a line(here a line means a L string of an element of the vector)
	    //insert blank to the line
	public:
	    vector<string> fullJustify(vector<string> &words, int L) {
	        
	        vector<string> ans;
	        vector<string> a_line;
	        int pos = 0;
	        
	        while (pos < words.size()) {
	            
	            a_line.clear();
	            a_line.push_back(words[pos]);
	            int word_num = 1;
	            int sum_word_length = words[pos].size();
	            int sum_line_length = words[pos++].size();
	            while (1) {
	                if ((pos >= words.size()) || (sum_line_length + words[pos].size() + 1 > L)) {
	                    break;
	                } else {
	                    word_num++;
	                    sum_word_length += words[pos].size();
	                    sum_line_length += words[pos].size() + 1;
	                    a_line.push_back(words[pos++]);
	                }
	            }
	            
	            if (pos == words.size()) {
	                string line_str = a_line[0];
	                for (int i = 1; i < a_line.size(); i++) {
	                    line_str += " " + a_line[i];
	                }
	                for (int i = line_str.size(); i < L; i++) {
	                    line_str += " ";
	                }
	                ans.push_back(line_str);
	                break;
	            }
	            
	            string line_str = a_line[0];
	            string blank;
	            int evenly_blank_num;
	            int remind_blank_num;
	            if (word_num == 1) {
	                for (int i = line_str.size(); i < L; i++) {
	                    line_str += " ";
	                }
	            } else {
	                evenly_blank_num = (L - sum_word_length) / (word_num - 1);
	                remind_blank_num = (L - sum_word_length) % (word_num - 1);
	                for (int i = 0; i < evenly_blank_num; i++) {
	                    blank += " ";
	                }
	                for (int i = 1; i < a_line.size(); i++) {
	                    line_str += blank;
	                    if (remind_blank_num) {
	                        line_str += " ";
	                        remind_blank_num--;
	                    }
	                    line_str += a_line[i];
	                }
	            }
	            ans.push_back(line_str);
	        }
	        return ans; 
	    }
	};
	
}
