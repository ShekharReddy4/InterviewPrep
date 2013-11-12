package Arraystrings;

//Make it a generic array list to use for implementing set
public class MyArrayList<T> {
	private final int INITIAL_CAPACITY = 2;
	// Cannot create a generic array because it is checked at compile time
	// but having the restriction on the add method has the same effect
	Object[] array;
	int size;
	
	public MyArrayList() {
		array = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	public void add(T addMe) {
		// If array isn't big enough, copy everything to a new bigger array
		// This is amortized O(1), but O(n)
		if (size >= array.length) {
			System.out.println("Increasing size");
			Object[] newArray = new Object[array.length * 2];
			for (int i = 0; i < array.length; ++i) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
		array[size] = addMe;
		
		++size;	
	}
	
	public void set(T setMe, int index) {
		if (index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		array[index] = setMe;
	}
	
	public void remove(Object removeMe) {
		// If we start to waste too much space then copy everything 
		// to a smaller array. Same amortized cost as add
		if (size < array.length / 2 && size > 2) {
			System.out.println("Decreasing capacity");
			Object[] newArray = new Object[array.length / 2];
			for (int i = 0; i < newArray.length; ++i) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
		
		for (int i = 0; i < size; ++i) {
			if (array[i].equals(removeMe)) {
				for (int j = i; j < size; ++j) {
					try {
						array[j] = array[j+1];
					}	
					catch (ArrayIndexOutOfBoundsException ex) {
						// Boundary case, but nothing wrong here
						array[j] = null;
					}
				}
				--size;
				return;
			}	
		}
		// Couldn't find what was specified
		// Maybe overkill to throw an exception here?
		throw new IllegalArgumentException();
	}
	
	public void remove(int index) {
		if (index > size-1 || index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if (size < array.length / 2 && size > 2) {
			System.out.println("Decreasing capacity");
			Object[] newArray = new Object[array.length / 2];
			for (int i = 0; i < newArray.length; ++i) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
		
		for (int i = index; i < size; ++i) {
			try {
				array[i] = array[i+1];
			}
			catch (ArrayIndexOutOfBoundsException ex) {
				// Boundary case, but nothing wrong here
				array[i] = null;
			}
		}
		--size;
	}
	
	public void printList () {
		for (int i = 0; i < size; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
