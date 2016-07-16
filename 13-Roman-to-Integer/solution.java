public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        int index = 0;
        while(index < len) {
            char c = s.charAt(index);
            switch (c) {
                case 'I':
                    if(index < len - 1 && s.charAt(index + 1) == 'V') {
                        res += 4;
                        index++;
                    }
                    else if(index < len - 1 && s.charAt(index + 1) == 'X') {
                        res += 9;
                        index++;
                    }
                    else {
                        res += 1;
                    }
                    break;
                case 'V': 
                    res += 5;
                    break;
                case 'X':
                    if(index < len - 1 && s.charAt(index + 1) == 'L') {
                        res += 40;
                        index++;
                    }
                    else if(index < len - 1 && s.charAt(index + 1) == 'C') {
                        res += 90;
                        index++;
                    }
                    else {
                        res += 10;
                    }
                    break;
                case 'L': 
                    res += 50;
                    break;
                case 'C':
                    if(index < len - 1 && s.charAt(index + 1) == 'D') {
                        res += 400;
                        index++;
                    }
                    else if(index < len - 1 && s.charAt(index + 1) == 'M') {
                        res += 900;
                        index++;
                    }
                    else {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
            index++;
        }
        
        return res;
    }
}