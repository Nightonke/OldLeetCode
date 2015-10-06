
public class _0208_Implement_Trie__Prefix_Tree_ {

/*	Implement a trie with insert, search, and startsWith methods.

	Note:
	You may assume that all inputs are consist of lowercase letters a-z.*/
	
	struct TrieNode {
		char c;
		struct TrieNode * son[27];  // sons for "abcdefghijklmnopqrstuvwxyz\0"
	};

	struct TrieNode * trieCreate() {
		struct TrieNode * trieNode = (struct TrieNode*)malloc(sizeof(struct TrieNode));
		trieNode->c = '\0';
		memset(trieNode->son, 0, sizeof(trieNode->son));
		return trieNode;
	}

	void insert(struct TrieNode * root, char * word) {
		if (*word == '\0') {
			root->son[26] = trieCreate();
			root->son[26]->c = '\0';  // notice that '\0' is important. There's "abc\0" in Trie doesn't mean there's a word "ab\0".
			return;
		}
		if (root->son[*word - 'a'] == NULL) {
			root->son[*word - 'a'] = trieCreate();
			root->son[*word - 'a']->c = *word;
			insert(root->son[*word - 'a'], word + 1);
		}
		else {
			insert(root->son[*word - 'a'], word + 1);
		}
	}

	bool search(struct TrieNode * root, char * word) {
		if (*word == '\0') {
			if (root->son[26] != NULL) return true;  // notice that '\0' is important. There's "abc\0" in Trie doesn't mean there's a word "ab\0".
			else return false;
		}
		if (root->son[*word - 'a'] == NULL) {
			return false;
		}
		else {
			return search(root->son[*word - 'a'], word + 1);
		}
	}

	bool startsWith(struct TrieNode * root, char * prefix) {
		if (*prefix == '\0') return true;  // but prefix is different. U didn't need a '\0' to make sure that it's an end of a word
		if (root->son[*prefix - 'a'] == NULL) {
			return false;
		}
		else {
			return startsWith(root->son[*prefix - 'a'], prefix + 1);
		}
	}

	void trieFree(struct TrieNode* root) {
		if (root != NULL) {
			for (int i = 0; i < 26; i++) {
				trieFree(root->son[i]);
			}
			free(root);
		}
	}
	
}
