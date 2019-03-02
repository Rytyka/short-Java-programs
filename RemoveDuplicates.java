package programs;
import java.util.Arrays;

/*
 * Removing duplicate characters in a string
 * 
 * Explanation: Keeping track of tail that is the length of the string
 * 
 * Take the i-th character. Check if it was existing before this place in the string. If it exists, then the algorithm deletes the i-th character. If it doesn't exists then it stays in the string.

The proof that it's the right algorithm: None of the characters will stay which existed earlier in the string. If a character would exists later in the string, it would be deleted because of the previous rule.

If this would be the algorithm, it would work fine, but there would be "Empty" characters in the string. The string wouldn't be smaller, even tough it should contain less characters.

That's why the algorithm keeps track on the "tail of the output string". That's why the tail is equals 1 at the beginning, since the 1st character will be definitely part of the result string. When the current character should be deleted, the output string's tail wont move, no new character added to the result. When the current character should be part of the result, then it gets copied to the tail of the result string.

When the algorithm reaches the end of the input string, it closes the result string.
 * 
 * *
 * 
 * If allowed some memory changes as follows: */
public class RemoveDuplicates {
	
	public static void removal(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		
		boolean tracker[] = new boolean[256];
		for(int i=0;i<256;i++) {
			tracker[i] = false;
		}
		int tail = 1;
		tracker[str[0]]=true;
		
		for(int i=1;i<len;i++) {
			if(!tracker[str[i]]) {
				str[tail] = str[i];
				++tail;
				tracker[str[i]] = true;
			}
			/*int j;
			for(j=0;j<tail;j++) {
				if(str[i]==str[j]) break;
			}
			if(j==tail) {
				str[tail] = str[i];
				++tail;
			}*/
		}
		str[tail]=0;
		System.out.println(Arrays.toString(str));
		
	}
	
	public static void main(String[] args) {
	
		removal("bbab".toCharArray());
		removal("ritika".toCharArray());
	}

}
