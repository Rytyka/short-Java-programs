/*
 * Decide if two strings are anagrams or not
 * 
 * */


package programs;
import java.util.Arrays;

public class Anagrams {
	
	public static boolean checkAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] frequency = new int[256];
		
		for(int i=0;i<s1.length();i++) {
			int ch= (int)s1.charAt(i);
			frequency[ch]++;
		}
		
		for(int j=0;j<s2.length();j++) {
			int ch = (int) s2.charAt(j);
			if(frequency[ch] == 0) return false;
			frequency[ch]--;
		}
		for(int k=0;k<256;k++) {
			if(frequency[k]>0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		
		System.out.println(checkAnagrams("b a","a a"));
		
	}
	

}
