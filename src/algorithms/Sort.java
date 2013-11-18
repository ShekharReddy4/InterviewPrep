package algorithms;

import java.util.Arrays;

public class Sort {
	
	static int[] mergeSort(int[] data) {
		if (data.length > 1) {
			int q = data.length / 2;
			
			int[] left = Arrays.copyOfRange(data, 0, q);
			int[] right = Arrays.copyOfRange(data, q, data.length);
			
			mergeSort(left);
			mergeSort(right);
			
			data = merge(data, left, right);
		}
		return data;
	}
	
	private static int[] merge(int[] data, int[] l, int[] r) {
		int mergeLength = l.length + r.length;
		int[] mergedArr = new int[mergeLength];
		
		int i, li, ri;
		i=li=ri=0;
		
		while ( i < mergeLength) {
			if ((li < l.length) && (ri < r.length)) {
				if (l[li] < r[ri]) {
					data[i] = l[li];
					++i;
					++li;
				}
				else {
					data[i] = r[ri];
					++i;
					++ri;
				}
			}
			else {
				if (li >= l.length) {
					while (ri < r.length) {
						data[i] = r[ri];
						++i;
						++ri;
					} 
				}
				if (ri >= r.length) {
					while (li < l.length) {
						data[i] = l[li];
						++i;
						++li;
					}
				}
			}
		}
		
		return mergedArr;
	}
}
