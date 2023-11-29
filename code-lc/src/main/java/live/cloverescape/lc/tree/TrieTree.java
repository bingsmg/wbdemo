package live.cloverescape.lc.tree;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class TrieTree {

    private final TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    private static class TrieNode {
        boolean isEnd;
        TrieNode[] tns = new TrieNode[26]; // trie nodes
    }

    private void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a'; // unicode
            if (p.tns[u] == null) {
                p.tns[u] = new TrieNode();
            }
            p = p.tns[u];
        }
        p.isEnd = true;
    }

    private boolean search(String word) {
        TrieNode p = searchPrefix(word);
        return p != null && p.isEnd;
    }

    private boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return null;
            }
            p = p.tns[u];
        }
        return p;
    }
}
