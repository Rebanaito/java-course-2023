package edu.hw2;

import java.util.Random;
import java.util.logging.Logger;

public class FaultyConnection implements Connection {

    private static final Logger LOGGER = Logger.getLogger("FaultyConnectionLogger");

    public void execute(String command) throws ConnectionException {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            LOGGER.info("Faulty connection failed to execute '" + command);
            throw new ConnectionException("Exception from execute", new Throwable("Cause"));
        } else {
            LOGGER.info("Executed '" + command + "' on a faulty connection");
        }
    }

    public void close() {
        LOGGER.info("Closing a faulty connection");
    }
}
