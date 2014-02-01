package algorithms;

import trees.and.graphs.BST;
import trees.and.graphs.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		int[] array = {7, 4, 5, 6, 8, 3, 9, 0, 1, 2};
		
		System.out.println("Sorted list: ");
		Sort.mergeSort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		System.out.println(Search.binarySearch(array, 10));
	}

}
