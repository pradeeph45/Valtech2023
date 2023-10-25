package Day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import CoreJava.Point;
import CoreJava.Point3D;

public class SerialTest {
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	Point p=new Point(2,3);
	System.out.println(p);
	ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("objects1")));
	objectOutputStream.writeObject(p);
	objectOutputStream.flush();
	objectOutputStream.close();
	ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("objects1")));
	Point p1=(Point)ois.readObject();
	System.out.println(p1);
	System.out.println(p==p1);
	
}
}
