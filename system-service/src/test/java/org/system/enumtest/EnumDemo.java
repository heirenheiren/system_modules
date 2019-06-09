package org.system.enumtest;

enum Color{GREEN,RED,BLUE}
public class EnumDemo {
	public static void main(String[] args) {
		execute(Color.GREEN);
	}

	private static void execute(Color color) {
		switch (color) {
		case GREEN:
			System.out.println("green");
			break;
		case RED:
			System.out.println("red");
			break;
		case BLUE:
			System.out.println("blue");
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}
