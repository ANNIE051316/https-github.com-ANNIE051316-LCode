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
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        if(nestedList == null) {
            return res;
        }
        
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        Queue<NestedInteger> nextLevel = new LinkedList<NestedInteger>();
        int level = 1;
        queue.addAll(nestedList);
        while(!queue.isEmpty()) {
            NestedInteger cur = queue.poll();
            if(cur.isInteger()) {
                res += level * cur.getInteger();
            }
            else {
                nextLevel.addAll(cur.getList());
            }
            
            if(queue.isEmpty()) {
                queue = nextLevel;
                nextLevel = new LinkedList<NestedInteger>();
                level++;
            }
        }
        
        return res;
    }
}