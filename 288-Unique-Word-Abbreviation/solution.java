public class ValidWordAbbr {
   Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, Set<String>>();
        for(String s : dictionary) {
            String ab = getAbbr(s);
            if(!map.containsKey(ab)) {
                map.put(ab, new HashSet<String>());
            }
            map.get(ab).add(s);
        }
    }
    
    private String getAbbr(String s) {
        int len = s.length();
        if(len <= 2) {
            return s;
        }
        else {
            return s.charAt(0) + String.valueOf(len - 2) + s.charAt(len - 1);
        }
    }

    public boolean isUnique(String word) {
        String ab = getAbbr(word);
        return !map.containsKey(ab) || (map.get(ab).size() == 1 && map.get(ab).contains(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");