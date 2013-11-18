package arrays.and.strings;

public class MyMap<K, V> {
	MyArrayList<MyEntry<K,V>> set;
	
	public MyMap() {
		set = new MyArrayList<MyEntry<K,V>>();
	}
	
	public void add(K key, V value) {
		// There may not be duplicate keys
		if (containsKey(key)) { return; }
		MyEntry entry = new MyEntry(key, value);
		set.add(entry);
	}
	
	public boolean containsKey(K key) {
		for (int i = 0; i < set.size; ++i) {
			MyEntry trustMeCompiler = (MyEntry) set.array[i];
			if (trustMeCompiler.getKey().equals(key)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void removeKey(K key) {
		// A messy solution. Ideally MyArrayList implements
		// iterable interface and has a find()
		for (int i = 0; i < set.size; ++i) {
			MyEntry trustMeCompiler = (MyEntry) set.array[i];
			if (trustMeCompiler.getKey() == key) {
				set.remove(i);
			}
		}
	}
	
	public void removeValue(V value) {
		for (int i = 0; i < set.size; ++i) {
			MyEntry trustMeCompiler = (MyEntry) set.array[i];
			if (trustMeCompiler.getValue() == value) {
				set.remove(i);
			}
		}
	}
	
	public void printMap() {
		for (int i = 0; i <set.size; ++i) {
			MyEntry trustMeCompiler = (MyEntry) set.array[i];
			System.out.println(trustMeCompiler.getKey() + " -> " + trustMeCompiler.getValue());
		}
	}
}
