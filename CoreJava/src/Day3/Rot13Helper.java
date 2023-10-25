package Day3;

public class Rot13Helper {
    public static char rotate(char achar) {
		if(achar>='a' && achar<='m') {
			achar=(char)(achar+13);
		}else if(achar>='n' && achar<='z'){
		  achar=(char)(achar-13);
		}else if(achar>='A' && achar<='M') {
			achar=(char)(achar+13);
		}
		else if(achar>='N' && achar<='Z'){
			  achar=(char)(achar-13);
		}
    	return achar;
    	
    }
    public static void main(String[] args) {
		String s="Hello World!";
		for(char ch:s.toCharArray())
    	System.out.println(rotate(rotate(ch)));
	}
}
