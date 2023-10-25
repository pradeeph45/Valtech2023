package CoreJava;

public class Point3D extends Point{
	
	

	public Point3D(int x, int y,int z) {
		super(x, y);
		this.z=z;
	}
	private int z;
	
	public double distance(int x,int y,int z) {
		
		int diffx=this.x-x;
		int diffy=this.y-y;
		int diffz=this.z-z;
		return Math.sqrt(diffx*diffx +diffy*diffy+diffz*diffz);
	}
	
	public double distance(Point3D p) {
		return distance(p.x,p.y,p.z);
	}
	
	public double distance() {
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public boolean equals(Object obj) {
		Point3D p=(Point3D) obj;
		return (p.x==x && p.y==y);
	}
	public static void main(String[] args) {
	
		Point3D p=new Point3D(20,20,20);
		System.out.println(p.distance(new Point(10,20)));
	}

}
