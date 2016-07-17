public class Solution {
    public int trap(int[] height) {
        int res = 0;
        if(height == null || height.length <= 2) {
            return res;
        }
        int index = 0;
        
        for(int i = 1; i < height.length; i++) {
            if(height[i] > height[index]) {
                index = i;
            }
        }
        
        int max = height[0];
        for(int i = 1; i < index; i++) {
            if(height[i] < max) {
                res += max - height[i];
            }
            else {
                max = height[i];
            }
        }
        
        max = height[height.length - 1];
        for(int i = height.length - 2; i > index; i--) {
            if(height[i] < max) {
                res += max - height[i];
            }
            else {
                max = height[i];
            }
        }
        
        return res;
        
    }
}