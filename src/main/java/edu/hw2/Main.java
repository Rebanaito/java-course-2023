package edu.hw2;

public class Main {
	public static void main(String[] args) {
		var info = Info.callingInfo(new Throwable());
		System.out.println(info.className());
		System.out.println(info.methodName());
	}
}