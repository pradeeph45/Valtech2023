package Day5;

public class AdderImpl implements Adder{
   public int add(int a,int b) {
	   return a+b;
   }
   public static void main(String[] args) {
	Adder a=new AdderImpl();
	System.out.println(a.add(2, 3));
	adderOld();
	
	//Lambda Expressions
	
	extracted();
	
}
private static void adderOld() {
	Adder a1=new Adder() {
		public int add(int a,int b) {
			return a+b;
		}
	};
}
private static void extracted() {
	Adder a2=(i,j) -> {return i+j;};
	System.out.println(a2.add(4, 2));
}
}
