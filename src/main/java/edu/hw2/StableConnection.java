package edu.hw2;

import java.util.logging.Logger;

public class StableConnection implements Connection {
	private static final Logger LOGGER = Logger.getLogger("StableConnectionLogger");
	public void execute(String command) {
		LOGGER.info("Executing '" + command + "' on a stable connection");
	}

	public void close() {
		LOGGER.info("Closing a stable connection");
	}
}