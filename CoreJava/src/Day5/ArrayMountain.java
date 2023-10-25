package Day5;

public class ArrayMountain {
   public boolean checkMountainArray(int[] a) {
	int maxIndex=0;
	int max=a[0];
	for(int i=0;i<a.length;i++) {
		if(max<a[i]) {
			max=a[i];
			maxIndex=i;
		}
	}
	int asc[]=new int[maxIndex];
	for(int i=0;i<maxIndex;i++) {
		asc[i]=a[i];
	}
	int desc[]=new int[100];
	int cnt=0;
	for(int i=maxIndex;i<a.length-1;i++) {
	  desc[cnt++]=a[i];
	}
	
	System.out.println(max);
			
	if(isAscending(asc) && isDescending(desc) && (maxIndex!=0 || maxIndex!=a.length-1))
		return true;
	return false;
	  
	   
   }
   
   public boolean isDescending(int [] a) {
	   for(int i=0;i<a.length-1;i++) {
		   if(a[i]<a[i+1])
			   return false;
	   }
	   return true;
   }
   public boolean isAscending(int [] a) {
	   for(int i=0;i<a.length-1;i++) {
		   if(a[i]>a[i+1])
			   return false;
	   }
	   return true;
   }
   
   
   public static void main(String[] args) {
	ArrayMountain a=new ArrayMountain();
	System.out.println(a.checkMountainArray(new int[] {1,2,3,4,5}));
	
   }
}
