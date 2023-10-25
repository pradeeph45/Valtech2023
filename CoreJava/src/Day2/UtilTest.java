package Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import CoreJava.Point;

public class UtilTest {

	public static void testStack(Stack<Point> points) {
		points.push(new Point(2, 3));
		points.push(new Point(2, 4));
		points.push(new Point(2, 3));
		points.push(new Point(2, 5));
		System.out.println("Size=" + points.size());
		System.out.println(points.pop());
		System.out.println("Size=" + points.size());
		System.out.println(points.peek());
		System.out.println("Size=" + points.size());
	}

	public static void testMap(Map<String, Point> points) {
		points.put("2,3", new Point(2, 3));
		points.put("2,3", new Point(2, 3));
		points.put("3,2", new Point(3, 2));
		points.put("2,4", new Point(2, 4));
		System.out.println("size=" + points.size());
		System.out.println(points);
	}

	public static void testList(List<Point> points) {
		Point p = new Point(2, 3);
		Point p1 = new Point(2, 3);

		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3, 2));
		points.add(new Point(2, 3));
		System.out.println("Size=" + points.size());
	}

	public static void testSet(Set<Point> set) {
		Point p = new Point(2, 3);
		Point p1 = new Point(2, 3);

		set.add(p);
		set.add(p1);
		set.add(p);
		set.add(new Point(3, 2));
		set.add(new Point(2, 3));
		System.out.println("Size=" + set.size());
	}

	public static void main(String[] args) {
//		testSet(new HashSet<>());
//		testSet(new TreeSet<>());
//		testList(new ArrayList<>());
//		testList(new LinkedList<>());
		// testMap(new HashMap<>());
       testStack(new Stack<>());
	}

}
