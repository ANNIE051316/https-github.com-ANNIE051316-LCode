/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        List<Integer> candidates = new ArrayList<Integer>();
        int left = 0, right = n - 1;
        while(left < right) {
            boolean lkr = knows(left, right);
            boolean rkl = knows(right, left);
            if(lkr && !rkl) {
                candidates.add(right);
            }
             if(rkl && !lkr) {
                candidates.add(left);
            }
            left++;
            right--;
        }
        if(n % 2 == 1) {
            candidates.add(left);
        }
        
        while(candidates.size() > 1) {
            int sz = candidates.size();
            left = 0; right = sz - 1;
            List<Integer> tmpCandidates = new ArrayList<Integer>();
            while(left < right) {
                int l = candidates.get(left);
                int r = candidates.get(right);
                boolean lkr = knows(l, r);
                boolean rkl = knows(r, l);
                if(!lkr && rkl) {
                    tmpCandidates.add(l);
                }
                if(lkr && !rkl) {
                    tmpCandidates.add(r);
                }
                left++;
                right--;
            }
            
            candidates = tmpCandidates;
        }
        
        if(candidates.size() == 0) {
            return -1 ;
        }
        for(int i = 0; i < n ; i++) {
            if(knows(candidate.get(0), i)) {
                return -1;
            }
        }
        return candidate.get(0);
    }
}