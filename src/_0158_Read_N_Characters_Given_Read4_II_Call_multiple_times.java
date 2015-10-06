
public class _0158_Read_N_Characters_Given_Read4_II_Call_multiple_times {

/*	The API: int read4(char *buf) reads 4 characters at a time from a file.

	The return value is the actual number of characters read. For example, it 
	returns 3 if there is only 3 characters left in the file.

	By using the read4 API, implement the function int read(char *buf, int n) 
	that reads n characters from the file.

	Note:
	The read function may be called multiple times.*/

	// Forward declaration of the read4 API.
	int read4(char *buf);

	class Solution {
	public:
	    /**
	    * @param buf Destination buffer
	    * @param n   Maximum number of characters to read
	    * @return    The number of characters read
	    */
	    queue<char> lastTimeChar;
	    int read(char *buf, int n) {
	        int now = 0, index = 0;
	        while (!lastTimeChar.empty()) {
	            if (index == n) return n;
	            buf[index++] = lastTimeChar.front();
	            lastTimeChar.pop();
	        }
	        while (index < n) {
	            now = read4(buf + index);
	            index += now;
	            if (now < 4) break;
	        }
	        for (int i = n; i < index; i++) {
	            lastTimeChar.push(buf[i]);
	        }
	        return min(index, n);
	    }
	};
	
}
