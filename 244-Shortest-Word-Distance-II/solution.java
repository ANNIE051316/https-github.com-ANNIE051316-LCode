public class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int sz1 = l1.size();
        int sz2 = l2.size();
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < sz1 && j < sz2) {
            int index1 = l1.get(i);
            int index2 = l2.get(j);
            res = Math.min(res, Math.abs(index1 - index2));
            if(index1 < index2) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return res;
        
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");