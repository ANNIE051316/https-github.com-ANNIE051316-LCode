public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        if(s.indexOf("IV") != -1) {
            res -= 2;
        }
        if(s.indexOf("IX") != -1) {
            res -= 2;
        }
        if(s.indexOf("XL") != -1) {
            res -= 20;
        }
        if(s.indexOf("XC") != -1) {
            res -= 20;
        }
        if(s.indexOf("CD") != -1) {
            res -= 200;
        }
        if(s.indexOf("CM") != 1) {
            res -= 200;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case "I":
                    res += 1;
                    break;
                case "V":
                    res += 5;
                    break;
                case "X":
                    res += 10;
                    break;
                case "L":
                    res += 50;
                    break;
                case "C":
                    res += 100;
                    break;
                case "D":
                    res += 500;
                    break;
                case "M":
                    res += 1000;
                    break;
                default:
                break;
            }
        }
        return res;
    }
}