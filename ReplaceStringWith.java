package programs;

import java.util.Arrays;

public class ReplaceStringWith {
	public static void stringReplacement(char[] str, int original_length) {
		int spaces = 0;
		int len = original_length;
		for(int i=0;i<len;i++) {
			if(str[i]==' ') spaces++;
		}
		int extra_spaces = spaces*2;
		int new_len = len + extra_spaces;
		int tail = new_len-1;
		for(int i=len-1; i>=0;i--) {
			if(str[i]==' ') {
				str[tail]='0';
				tail--;
				str[tail]='2';
				tail--;
				str[tail]='%';
				tail--;
			}
			else {
				str[tail]=str[i];
				tail--;
			}
		}
		
	}
	public static void main(String[] args) {
		String str= "ritika is  awesome ";
		
		int len = str.length();
		int spaces=0;
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ') spaces++;
		}
		int extra_spaces = spaces*2;
		char[] str_arr = new char[len+extra_spaces];
		int l=0;
		while(l<str_arr.length) {
			if(l<str.length()) str_arr[l]=str.charAt(l);
			else str_arr[l]=' ';
			l++;
		}
		
		stringReplacement(str_arr,len);
		System.out.println(Arrays.toString(str_arr));
		
	}
}
