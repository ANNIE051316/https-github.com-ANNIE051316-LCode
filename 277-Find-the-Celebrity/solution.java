/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        List<Integer> candidates = new ArrayList<Integer>();
        int left = 0, right = n - 1;
        while(left < right) {
            boolean kno = knows(left, right);
            if(kno) {
                candidates.add(right);
            }
            else {
                candidates.add(left);
            }
            left++;
            right--;
        }
        
        while(candidates.size() > 1) {
            int sz = candidates.size();
            left = 0, right = sz - 1;
            while(left < right) {
                boolean kno = knows(left, right);
                if(kno) {
                candidates.remove(left);
                }
                else {
                    candidates.remove(right);
                }
                left++;
                right--;
            }
        }
        
        return candidates.size() == 0 ? -1 : candidates.get(0);
    }
}