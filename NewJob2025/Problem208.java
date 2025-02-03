// 208. Implement Trie (Prefix Tree) - M

class Trie {
    Trie[] store;
    boolean isWordEnd;

    public Trie() {
        this.store = new Trie[26]; 
        this.isWordEnd = false;
    }

    private Trie(boolean isWordEnd) {
        this.store = new Trie[26]; 
        this.isWordEnd = isWordEnd;       
    }
    
    private boolean isEmptyAtIndex(int index) {
        return (this.store[index] == null);
    }

    public void insert(String word) {
        if (word.length() == 0) return;
        //if (word.equals("apple")) return;
        //if (word.equals("beer")) return;
        //if (word.equals("add")) return;
        //if (word.equals("jam")) return;
        //if (word.equals("rental")) return;
        Trie pointer = new Trie();
        pointer.store = this.store;
        for (int i = 0; i < word.length() - 1; i++) {
            if (pointer.isEmptyAtIndex(word.charAt(i) - 'a')) {
                Trie t = new Trie(); // not the end of the word
                pointer.store[word.charAt(i) - 'a'] = t;
            }
            pointer = pointer.store[word.charAt(i) - 'a'];
        }

        if (pointer.isEmptyAtIndex(word.charAt(word.length() - 1) - 'a')) {
            Trie t = new Trie(true);
            pointer.store[word.charAt(word.length() - 1) - 'a'] = t;
        } else {
            pointer.store[word.charAt(word.length() - 1) - 'a'].isWordEnd = true;
        }
    }
    
    public boolean search(String word) {
        if (word.length() == 0) return true;
        Trie pointer = this;
        
        for (int i = 0; i < word.length(); i++) {
            if (pointer.isEmptyAtIndex(word.charAt(i) - 'a')) return false;
            pointer = pointer.store[word.charAt(i) - 'a'];
        }
        //return true;
        return (pointer.isWordEnd == true);
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;
        Trie pointer = this;
        
        for (int i = 0; i < prefix.length(); i++) {
            if (pointer.isEmptyAtIndex(prefix.charAt(i) - 'a')) return false;
            pointer = pointer.store[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// CLEANER  - separate TRIE and TRIE NODE:
class TrieNode {
    TrieNode[] children = new TrieNode[26];  // Fixed array for a-z
    boolean isEnd = false;
}

class Trie {
    private TrieNode root;
}
