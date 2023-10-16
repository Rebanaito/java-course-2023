package edu.hw2;

import java.util.Random;
import java.util.logging.Logger;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger("DefaultManagerLogger");

    public Connection getConnection() {
        Connection conn;
        Random rand = new Random();
        if (rand.nextBoolean()) {
            LOGGER.info("Creating a stable connection");
            conn = new StableConnection();
        } else {
            LOGGER.info("Creating a faulty connection");
            conn = new FaultyConnection();
        }
        return conn;
    }
}
