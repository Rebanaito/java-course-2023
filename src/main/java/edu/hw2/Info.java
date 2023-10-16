package edu.hw2;

public class Info {
	public record CallingInfo(String className, String methodName) {
	}

	public static CallingInfo callingInfo(Throwable info) {
		var stack = info.getStackTrace();
		return new CallingInfo(stack[stack.length-1].getClassName(), stack[stack.length-1].getMethodName());
	}

	public static CallingInfo callingInfo() {
		var stack = Thread.currentThread().getStackTrace();
		return new CallingInfo(stack[stack.length-1].getClassName(), stack[stack.length-1].getMethodName());
	}
}