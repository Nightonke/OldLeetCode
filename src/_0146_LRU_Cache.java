
public class _0146_LRU_Cache {

/*	Design and implement a data structure for Least Recently Used (LRU) cache. 
 *  It should support the following operations: get and set.

	get(key) - Get the value (will always be positive) of the key if the key 
	exists in the cache, otherwise return -1.
	set(key, value) - Set or insert the value if the key is not already present. 
	When the cache reached its capacity, it should invalidate the least recently 
	used item before inserting a new item.*/

	class LRUCache{
	public:
	    LRUCache(int capacity) {
	        ca = capacity;
	        global_vis = 0;
	        now = 0;
	        cache = new C[capacity];
	        for (int i = 0; i < capacity; i++) cache[i].vis = -1;
	    }
	    ~LRUCache() {
	        delete []cache;
	    }
	    int get(int key) {
	        global_vis++;
	        for (int i = 0; i < now; i++) {
	            if (cache[i].k == key && cache[i].vis != -1) {
	                cache[i].vis = global_vis;
	                return cache[i].v;
	            }
	        }
	        return -1;
	    }
	    
	    void set(int key, int value) {
	        global_vis++;
	        for (int i = 0; i < now; i++) {
	            if (cache[i].k == key) {
	                cache[i].v = value;
	                cache[i].vis = global_vis;
	                return;
	            }
	        }
	        if (now == ca) {
	            int min = cache[0].vis;
	            int pos = 0;
	            for (int i = 0; i < ca; i++) {
	                if (min > cache[i].vis) {
	                    min = cache[i].vis;
	                    pos = i;
	                }
	            }
	            cache[pos].k = key;
	            cache[pos].v = value;
	            cache[pos].vis = global_vis;
	        } else {
	            cache[now].k = key;
	            cache[now].vis = global_vis;
	            cache[now++].v = value;
	        }
	    }
	private:
	    struct C {
	        int vis;
	        int k;
	        int v;
	    };
	    C *cache;
	    int ca;
	    int now;
	    int global_vis;
	};
	
}
