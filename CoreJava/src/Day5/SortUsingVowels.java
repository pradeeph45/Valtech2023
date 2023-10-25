package Day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



public class SortUsingVowels {


 

 private String sortedString(String string) {
	 String[] words=(string.toLowerCase()).split(" ");
	 String finalString="";
	Map<String,Double> map=new HashMap<>();
	for(String str1:words) {
		map.put(str1, (Double)((Double)str1.length()-(Double)NumberOfVowels(str1))/((Double)(str1.length()));
	}
	 return finalString;
 }


public int NumberOfVowels(String str) {
	int count=0;
	for(int i=0;i<str.length();i++) {
		char ch=str.charAt(i);
		if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' ) {
			count++;
		}
	}
	return count;
}
	
	public static void main(String[] args) {
		SortUsingVowels s1=new SortUsingVowels();
		System.out.println(s1.sortedString("Hello How Are You"));
	}
}

