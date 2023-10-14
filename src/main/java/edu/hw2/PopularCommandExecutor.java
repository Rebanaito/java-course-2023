package edu.hw2;

import java.util.logging.Logger;

public final class PopularCommandExecutor {
	public PopularCommandExecutor(ConnectionManager manager, int attempts) {
		this.manager = manager;
		this.maxAttempts = attempts;
	}

	private static final Logger LOGGER = Logger.getLogger("ExecutorLogger");
	private final ConnectionManager manager;
	private final int maxAttempts;

	void updatePackages() {
		tryExecute("apt update && apt upgrade -y");
	}

	public void tryExecute(String command) throws ConnectionException {
		Exception e = null;
		for (int i = 0; i < this.maxAttempts; i++) {
			try (Connection conn = this.manager.getConnection()) {
				conn.execute(command);
				return;
			} catch (Exception exc) {
				e = exc;
			}
		}
		throw new ConnectionException("Could not execute", e);
	}
}
