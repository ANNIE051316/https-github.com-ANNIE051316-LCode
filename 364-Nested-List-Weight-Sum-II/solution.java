/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        int height = height(nestedList);
        return sumHelper(nestedList, height);
    }
    
    public int sumHelper(List<NestedInteger> nestedList, int height) {
        int res = 0;
        for(NestedInteger nested : nestedList) {
            if(nested.isInteger()) {
                res += nested.getInteger() * height;
            }
            else {
                res += sumHelper(nested.getList(), height - 1);
            }
        }
        
        return res;
    }
    
    public int height(List<NestedInteger> nestedList) {
        int res = 0;
        for(NestedInteger nested : nestedList) {
            if(nested.isInteger()) {
                res = Math.max(1, res);
            }
            else {
                res = Math.max(res, 1 + height(nested.getList()));
            }
        }
        
        return res;
    }
}