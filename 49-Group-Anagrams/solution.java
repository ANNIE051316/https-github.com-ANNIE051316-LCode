public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs == null || strs.length == 0) {
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String key = String.valueOf(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
      /*  for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
        
        */
        return new ArrayList<List<String>>(map.values());
        
    }
}