package Arraystrings;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		System.out.println(atoi("-110"));
	}
	
	static int atoi(String str) {
		int ret = 0;
	
		int i = 1;
		int neg = 1;
		int digit = 1;
		
		if (str.charAt(0) == '-') {
			neg = -1;
			++i;
		}
		
		while (i <= str.length()) {
			ret += digit * (str.charAt(str.length()-i) - (byte) '0');
			digit *= 10;
			++i;
		}
		return ret*neg;
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
