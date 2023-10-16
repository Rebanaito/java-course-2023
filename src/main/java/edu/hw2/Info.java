package edu.hw2;

public class Info {
	public record CallingInfo(String className, String methodName) {
	}

	public static CallingInfo callingInfo() {
		var stack = Thread.currentThread().getStackTrace();
		return new CallingInfo(stack[2].getClassName(), stack[2].getMethodName());
	}
}
