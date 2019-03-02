package programs;

/* * * * *
 * 
 * Determine if the string has all unique characters without additional data structures
 * 
 * * * */

public class uniqueCharacters {
	
	public static boolean uniqueChecker(String str) {
		
		//assuming a-z so that the boolean flags can fit in an int
		long flag = 0;
		long val;
		for(int i=0;i<str.length();i++) {
			val = str.charAt(i);
			//System.out.println(Long.toBinaryString(~(1<<val)));
			if((flag & (1L<<val)) > 0L) {
				return false;
				}
			flag |= (1L<<val);
			}
			
			return true;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(uniqueChecker(";!=A"));
		System.out.println(uniqueChecker("  "));
		
	}

}
