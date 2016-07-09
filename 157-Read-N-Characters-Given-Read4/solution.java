/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] buf4 = new char[4];
        int i = 0;
        boolean eof = false;
        while(i < n && !eof) {
            int curread = read4(buf4);
            if(curread < 4) {
                eof = true;
            }
            for(int j = 0; i < n && j < curread; j++) {
                buf[i++] = buf4[j];
            }
        }
        
        return i;
        
    }
}