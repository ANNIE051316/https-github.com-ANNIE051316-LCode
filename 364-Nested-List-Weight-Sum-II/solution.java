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
        int weighted = 0;
        int unweighted = 0;
        while(nestedList.size() != 0) {
            List<NestedInteger> nextLevel = new ArrayList();
            for(NestedInteger nested : nestedList) {
                if(nested.isInteger()) {
                    unweighted += nested.getInteger();
                }
                else {
                    nextLevel.addAll(nested.getList());
                }
            }
            
            weighted += unweighted;
            nestedList = nextLevel;
        }
        
        return weighted;
    }
}