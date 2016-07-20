public class WordDictionary {
    class Trie {
        Trie[] children;
        boolean isleaf;
        Trie() {
            children = new Trie[26];
        }
    }
    
    Trie head;
    public WordDictionary() {
        head = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        int len = word.length();
        Trie cur = head;
        for(int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isleaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int len = word.length();
       return searchhelper(word, 0, len, head);
    }
    
    private boolean searchhelper(String word, int start, int end, Trie cur) {
        if(cur == null) {
            return false;
        }
        if(start > end) {
            return cur.isLeaf; 
        }
        char c = word.charAt(start);
        if(c == '.') {
            for(int i = 0; i < 25; i++) {
                if(cur.children[i] != null && searchhelper(word, start + 1, end, cur.children[i])) {
                    return true;
                }
            }
            return false;
        }
        else {
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            return searchhelper(word, start + 1, end, cur.children[c - 'a']);
        }
        
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");