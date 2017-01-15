import java.util.LinkedHashMap;
import java.util.Map;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 it should invalidate the least recently used item before inserting a new item.*/
public class _146_LRUCache {

}

// answer
class LRUCache {

	private LinkedHashMap<Integer, Integer> map;
	private final int CAPACITY;

	public LRUCache(int capacity) {
		CAPACITY = capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > CAPACITY;
			}
		};
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		map.put(key, value);
	}
}