class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        isWord = false;
        children = new HashMap<Character, TrieNode> ();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        char[] c = word.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            if(!p.children.containsKey(c[i])) p.children.put(c[i], new TrieNode());
            p = p.children.get(c[i]);
            if(i == c.length - 1) p.isWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        
        for(int i = 0; i < word.length(); i++) {
            TrieNode next = tmp.children.get(word.charAt(i));
            if(next == null) return false;
            else tmp = next;
        }
        return tmp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        
        for(int i = 0; i < prefix.length(); i++) {
            TrieNode next = tmp.children.get(prefix.charAt(i));
            if(next == null) return false;
            else tmp = next;
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
