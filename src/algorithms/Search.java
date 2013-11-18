package algorithms;

public class Search {
	
	static int binarySearch(int[] data, int find) {
		int mid;
		int high = data.length-1;
		int low = 0;
	    while (low <= high) {
	        mid = (low + high) / 2;
	        if (data[mid] > find) {
	            high = mid - 1;
	        } else if (data[mid] < find) {
	            low = mid + 1;
	        } else {
	            return mid;
	        }
	    }
		return 0;
	}
}
