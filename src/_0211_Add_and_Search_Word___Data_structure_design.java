
public class _0211_Add_and_Search_Word___Data_structure_design {

/*	Design a data structure that supports the following two operations:

	void addWord(word)
	bool search(word)
	search(word) can search a literal word or a regular expression string 
	containing only letters a-z or .. A . means it can represent any one letter.

	For example:

	addWord("bad")
	addWord("dad")
	addWord("mad")
	search("pad") -> false
	search("bad") -> true
	search(".ad") -> true
	search("b..") -> true
	Note:
	You may assume that all words are consist of lowercase letters a-z.*/
	
	struct WordDictionary {
		char c;
		// sons for "abcdefghijklmnopqrstuvwxyz\0"
		struct WordDictionary * son[27];  
	};

	/** Initialize your data structure here. */
	struct WordDictionary* wordDictionaryCreate() {
		struct WordDictionary * WordDictionary = 
			(struct WordDictionary*)malloc(sizeof(struct WordDictionary));
		WordDictionary->c = '\0';
		memset(WordDictionary->son, 0, sizeof(WordDictionary->son));
		return WordDictionary;
	}

	/** Inserts a word into the data structure. */
	void addWord(struct WordDictionary * wordDictionary, char * word) {
		if (*word == '\0') {
			wordDictionary->son[26] = wordDictionaryCreate();
			// notice that '\0' is important. 
			// There's "abc\0" in Trie doesn't mean there's a word "ab\0".
			wordDictionary->son[26]->c = '\0';  
			return;
		}
		if (wordDictionary->son[*word - 'a'] == NULL) {
			wordDictionary->son[*word - 'a'] = wordDictionaryCreate();
			wordDictionary->son[*word - 'a']->c = *word;
			addWord(wordDictionary->son[*word - 'a'], word + 1);
		}
		else {
			addWord(wordDictionary->son[*word - 'a'], word + 1);
		}
	}

	/** Returns if the word is in the data structure. A word could
	contain the dot character '.' to represent any one letter. */
	bool search(struct WordDictionary * wordDictionary, char * word) {
		if (*word == '\0') {
			if (wordDictionary->son[26] != NULL) return true;
			else return false;
		}
		if (*word == '.') {
			for (int i = 0; i < 26; i++) {
				if (wordDictionary->son[i] != NULL) {
					if (search(wordDictionary->son[i], word + 1))
						return true;
				}
			}
		}
		else {
			if (wordDictionary->son[*word - 'a'] == NULL) {
				return false;
			}
			else {
				return search(wordDictionary->son[*word - 'a'], word + 1);
			}
		}
	}

	/** Deallocates memory previously allocated for the data structure. */
	void wordDictionaryFree(struct WordDictionary * wordDictionary) {
		if (wordDictionary != NULL) {
			for (int i = 0; i < 26; i++) {
				wordDictionaryFree(wordDictionary->son[i]);
			}
			free(wordDictionary);
		}
	}
	
}
