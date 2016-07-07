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
        int index1 = l1.get(0);
        int index2 = l2.get(0);
        int res = Math.abs(index2 - index1);
        int i1 = 0;
        int i2 = 0;
        while(i1 < sz1 && i2 < sz2) {
            if(index1 < index2) {
                i1++;
                if(i1 >= sz1) {
                    break;
                }
                index1 = l1.get(i1);
            }
            else {
                i2++;
                if(i2 >= sz2) {
                    break;
                }
                index2 = l2.get(i2);
            }
            
            res = Math.min(res, Math.abs(index1 - index2));
        }
        
        return res;
        
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");