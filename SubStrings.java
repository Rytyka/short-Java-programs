package programs;
/*
 * Check if a second string is the rotation of the first string
 * 
 * */
public class SubStrings {

public static boolean checkForRotation(String s1, String s2) {
	if(s1.length() != s2.length()) return false;
	String s11= s1.concat(s1);
	if(s11.contains(s2)) return true;
	return false;
}
	
public static void main(String[] args) {
	
	System.out.println(checkForRotation("ritika","akriti"));
	
}	
}
