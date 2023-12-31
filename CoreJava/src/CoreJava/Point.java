package CoreJava;


import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable {
	public static final Point ORIGIN = new Point();
	static {
		// ORIGIN.x=1000;
		// ORIGIN.y=2000;
		System.out.println(ORIGIN);
	}
	protected int x;
	protected transient int y;

	public Point() {
		System.out.println("Point Method");
	}

	public Point(int x, int y) {
		System.out.println("In ctr of Point");
		// super();
		this.x = x;
		this.y = y;
	}
   
	
	
	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}

	@Override
	public int hashCode() {

		return toString().hashCode();
	}

	@Override
	public String toString() {

		return "X = " + x + " Y = " + y + " Distance = " + distance();
	}

	public double distance(Point p) {
		System.out.println("Distance with other points");
		return distance(p.x, p.y);
	}

	public double distance(int x, int y) {
		int diffx = this.x - x;
		int diffy = this.y - y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}

	public double distance() {
		System.out.println("Distance from Origin");
		int diffx = ORIGIN.x - x;
		int diffy = ORIGIN.y - y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}

	public static void main(String[] args) {
		Point p = new Point();
		p.x = 10;
		p.y = 20;
		System.out.println(p);
		// System.out.println(p.distance());
	}

	@Override
	public int compareTo(Point o) {
		
		
		return (x-o.x)==0?(y-o.y):(x-o.x);
	}

}
