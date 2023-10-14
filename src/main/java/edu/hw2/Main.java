package edu.hw2;

public class Main {
	public static void main(String[] args) {
		PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
		try {
			executor.tryExecute("shutdown now");
		} catch (ConnectionException exc) {
			System.out.println(exc.getMessage() + ": " + exc.getCause());
		}
	}
}