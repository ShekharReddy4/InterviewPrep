package algorithms;

import java.util.Arrays;

public class Sort {
	
	static void mergeSort(int[] arr) {
		if (arr.length == 1) {
			return;
		} else {
			int mid = arr.length / 2;
			
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			mergeSort(left);
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);
			mergeSort(right);
			
			merge(arr, left, right);
		}
	}
	
	private static void merge(int[] arr, int[] left, int[] right) {
		int li = 0; int ri = 0; int ai = 0;
		
		while (li < left.length && ri < right.length) {
			if (left[li] <= right[ri]) {
				arr[ai] = left[li++];
			} else {
				arr[ai] = right[ri++];
			}
			++ai;
		}
		
		if (li == left.length) {
			while (ri < right.length) {
				arr[ai] = right[ri++];
				++ai;
			}
		} else {
			while (li < left.length) {
				arr[ai] = left[li++];
				++ai;
			}
		}
	}
}
