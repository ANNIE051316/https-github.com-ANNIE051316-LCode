public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode head;
    
    public WordDictionary() {
        head = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode root =  head;
        if(word == null || word.length() == 0) {
            return;
        }
        
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(root.children[cur - 'a'] == null) {
                root.children[cur - 'a'] = new TrieNode();
            }
            root = root.children[cur - 'a'];
        }
        root.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        return searchHelper(word, head, 0);
        
    }
    
    public boolean searchHelper(String word, TrieNode curNode, int index) {
       
            char c = word.charAt(index);
            if(c == '.') {
                for(TrieNode node : curNode.children) {
                    if(node == null) {
                        continue;
                    }
                    if(searchHelper(word, node, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if(curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c  - 'a'];
                return searchHelper(word, curNode, index + 1);
            }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");