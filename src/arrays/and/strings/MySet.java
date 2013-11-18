package arrays.and.strings;


// Conveniently, a set is same as array list except it checks for duplicates on add 
// This is an ordered set. We could also do an unordered set using BST instead of array
public class MySet<T> extends MyArrayList<T> {
	
	public MySet() {
		super();
	}
	
	@Override
	public void add(T addMe) {
		for (int i = 0; i < super.size; ++i) {
			if (super.array[i].equals(addMe)) {
				return;
			}
		}

		super.add(addMe);
	}
}
