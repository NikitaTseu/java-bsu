import java.util.Scanner;

public class Point {
	
	double x, y;
	boolean exists;
	
	Point() {
		x = 0;
		y = 0;
		exists = false;
	}
	
	Point(double x0, double y0) {
		x = x0;
		y = y0;
		exists = true;
	}
	
	void setCoord(double x0, double y0) {
		x = x0;
		y = y0;
	}
	
	double getX() throws Exception {
		if(!exists) {
			throw new Exception("Error! The point doesn't exist.");
		}
		return x;
	}
	
	double getY() throws Exception {
		if(!exists) {
			throw new Exception("Error! The point doesn't exist.");
		}
		return y;
	}
	
	void printCoord() throws Exception {
		if(!exists) {
			throw new Exception("Error! The point doesn't exist.");
		}
		System.out.println("Point coordinates = (" + x + "; " + y + ")");
	}
	
	void move(double x0, double y0) throws Exception {
		if(!exists) {
			throw new Exception("Error! The point doesn't exist.");
		}
		x += x0;
		y += y0;
	}
	
	void rotate(double angle) throws Exception {
		if(!exists) {
			throw new Exception("Error! The point doesn't exist.");
		}
		
		double x0 = x;
		double y0 = y;
		x = x0 * Math.cos(angle) - y0 * Math.sin(angle);
		y = x0 * Math.sin(angle) + y0 * Math.cos(angle);
	}
}