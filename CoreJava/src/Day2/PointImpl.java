package Day2;

public class PointImpl implements Point {
    
	@Override
	public double distance(int a, int b) {
		
		return a*a+b*b;
	}

	@Override
	public double add(int a, int b) {
		
		return a+b;
	}

	@Override
	public double sub(int a, int b) {
		
		return a-b;
	}
	public static void main(String[] args) {
		Point p=new PointImpl();
		System.out.println(p.distance(2,3));
		
	}

}
