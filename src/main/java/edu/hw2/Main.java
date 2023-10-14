package edu.hw2;

public class Main {
	public static void main(String[] args) {
		var rect = new Rectangle(2, 4);
		System.out.println(rect.area());
		rect = rect.setWidth(5);
		System.out.println(rect.area());

		var sq = new Square(2);
		System.out.println(sq.area());
		sq = sq.setWidth(4);
		System.out.println(sq.area());
	}
}