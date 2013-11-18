package arrays.and.strings;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		MyArrayList al = new MyArrayList();
		al.printList();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		al.add(new Integer(5));
		al.add(new Integer(6));
		al.add(new Integer(7));
		al.add(new Integer(8));
		al.set(new Integer(-4), 3);
		al.printList();
		al.remove(0);
		al.remove(0);
		al.printList();
		
		MyMap<Integer, String> mm = new MyMap<Integer, String>();
		mm.add(new Integer(1), "one");
		mm.add(new Integer(2), "two");
		mm.add(new Integer(99), "two");
		mm.add(new Integer(3), "three");
		mm.add(new Integer(3), "shouldn't work");
		mm.removeValue("one");
		mm.removeKey(new Integer(2));
		mm.printMap();
		
		MySet ms = new MySet<String>();
		ms.add("ASDF");
		ms.add("asdf");
		ms.add("ASDF"); // This shouldn't be added again.
		ms.printList();
	}
	
	static int atoi(String str) {
		int ret = 0;
	
		int i = str.length() - 1;
		int negMultiplier = 1;
		// Let the while loop know we're dealing with a negative number
		int stopParsingAt = 0;
		// base 10 nth digit of the integer
		int digit = 1;
		
		if (str.charAt(0) == '-') {
			// Multiply final output by -1 to convert to negative
			negMultiplier = -1;
			// Stop 1 character early to not parse the '-'
			++stopParsingAt;
		}
		
		while (i >= stopParsingAt) {
			ret += digit * (str.charAt(i) - '0');
			digit *= 10;
			--i;
		}
		return ret*negMultiplier;
	}
	
	static String itoa(int n) {
		boolean neg = false;
		String ret = "";
		
		if (n < 0) {
			neg = true;
			// Convert back to positive
			n *= -1;
		}
		
		while (n > 0) {
			char x = (char) (n % 10 + '0');
			ret = x + ret;
			n /= 10;
		}
		
		if (neg) {
			ret = '-' + ret;
		}
		
		return ret;
	}
	
	// O(n^2) run time, O(1) memory
	static char findFstNonRptChar(String str) {
		if (str.isEmpty() || str == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				// Special case of when i has reached the end of the
				// string and second for loop wouldn't run
				if (i == j && i == str.length()-1) { return str.charAt(i); }
				// Don't compare char to itself
				if (i == j) { continue; }
				// Definitely repeats, try the comparing the next char
				if (str.charAt(i) == str.charAt(j)) {
					break;
				}
				else {
					// if they're the same
					if (j < str.length() - 1) {
						// Check the rest of the string
						continue;
					}
					else {
						// We reached the end and haven't found a dupe
						return str.charAt(i);
					}
				}
			}
		}
		return '\0';
	}
	
	// Can use mutable integer wrapper class to make even faster
	// O(n) run time, O(n) memory
	static char hashFindFstNonRptChar(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		HashMap<Character, Integer> hashtable = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Integer count = hashtable.get(str.charAt(i));
			//System.out.println("i="+i);
			// Use a custom mutable class to make even faster
			if (count == null) {
				hashtable.put(str.charAt(i), 1);
				//System.out.println("Put in '" + str.charAt(i) + "' with count 1");
			}
			else {
				hashtable.put(str.charAt(i), count+1);
				//System.out.println("Put in '" + str.charAt(i) + "' with count " + (count+1));
			}
			
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (hashtable.get(str.charAt(i)) == 1) {
				return str.charAt(i);
			}
		}
		return '\0';
	}
	
	// O(nm) run time, O(1) memory (Assuming only standard 128/256 chars are used)
	static String removeChars(String str, String remove) {
		if (str.isEmpty() || str == null) { throw new IllegalArgumentException(); }
		if (remove.isEmpty() || remove == null) { return str; }
		int size = 0;
		String temp = "";
		for (int i = 0; i < str.length(); ++i) {
			for (int j = 0; j < remove.length(); ++j) {
				if (str.charAt(i) == remove.charAt(j)) {
					break;
				}
				else {
					if (j < remove.length()-1) {
						continue;
					}
					else {
						temp += str.charAt(i);
					}
				}
				
			}
		}
		str = temp;
		return str;
	}
	
	// Uses array indexer to reduce run time
	static String hashRemoveChars(String str, String remove) {
		if (str.isEmpty() || str == null) { throw new IllegalArgumentException(); }
		if (remove.isEmpty() || remove == null) { return str; }
		String ret = "";
		
		boolean[] lookUpArray = new boolean[256];
		for (int i = 0; i < remove.length(); ++i) {
			lookUpArray[(int) remove.charAt(i)] = true;
		}
		for (int j = 0; j < str.length(); ++j) {
			if (lookUpArray[(int) str.charAt(j)] == true) {
				continue;
			}
			else {
				ret += str.charAt(j);
			}
		}
		return ret;
	}
	
	// Reverses the order of words only. 
	static String reverseWords(String str) {
		if (str == null) {
			throw new IllegalArgumentException();
		}
		
		return reverseEachWord(reverseString(str));
	}
	
	// Preserves word order, but each word is reversed
	static String reverseEachWord(String str) {
		if (str == null) {
			throw new IllegalArgumentException();
		}
		
		String ret = "";
		int i = 0;
		int j = 0;
		
		while (j < str.length()) {
			if (breakWord(str.charAt(j))) {
				ret+=reverseString(str.substring(i, j));
				ret+=str.charAt(j);
				i = j+1;
			}
			++j;
		}
		
		if (j == str.length()) {
			ret+=reverseString(str.substring(i, j));
		}
		
		return ret;
	}
	
	// Modify as necessary to fit the definition of break characters	
	private static boolean breakWord(char c) {
		if (c == ' ' || c == '\t' || c == '\n' || c == '\0') { return true; }
		return false;
	}
	
	// Reverses the entire string
	static String reverseString(String str) {
		if (str == null) {
			throw new IllegalArgumentException();
		}
		int i = 0;
		int j = str.length() - 1;
		char[] ret = new char[str.length()];
		while (i <= j) {
			char temp = str.charAt(j);
			ret[j] = str.charAt(i);
			ret[i] = temp;
			++i;
			--j;
		}
		return new String(ret);
	}
}
