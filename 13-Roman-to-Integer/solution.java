public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        int prev = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += prev;
                    prev = 1;
                    break;
                case 'V':
                    if(prev == 1) {
                        prev = 4;
                    }
                    else {
                        res += prev;
                        prev = 5;
                    }
                    break;
                case 'X':
                    if(prev == 1) {
                        prev = 9;
                    }
                    else {
                        res += prev;
                        prev = 10;
                    }
                    break;
                case 'L':
                    if(prev == 10) {
                        prev = 40;
                    }
                    else {
                        res += prev;
                        prev = 50;
                    }
                    break;
                case 'C':
                    if(prev == 10) {
                        prev = 90;
                    }
                    else {
                        res += prev;
                        prev = 100;
                    }
                    break;
                case 'D':
                    if(prev == 100) {
                        prev = 400;
                    }
                    else {
                        res += prev;
                        prev = 500;
                    }
                    break;
                case 'M':
                    if(prev == 100) {
                        prev = 900;
                    }
                    else {
                        res += prev;
                        prev = 1000;
                    }
                    break;
                default:
                    break;
            }
        }
        
        res += prev;
        return res;
    }
}