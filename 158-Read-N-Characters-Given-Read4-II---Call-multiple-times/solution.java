/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     char[] buf4 = new char[4];
     int curindex = 0;
     int numread = -1;
     
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n) {
            while(i < n && curindex < numread) {
                buf[i++] = buf4[curindex++];
            }
            if(curindex >= numread && (numread == -1 || numread == 4)) {
                curindex = 0;
                numread = read4(buf4);
            }
            else {
                break;
            }
        }
        
        return i;
    }
}