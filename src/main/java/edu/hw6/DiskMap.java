package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final static Logger LOGGER = Logger.getLogger("LOGGER");
    private final static Map<String, String> MAP = new HashMap<>();
    private final static String FILENAME = "diskMap.txt";
    private final static BufferedReader READER;

    static {
        BufferedReader temp;
        try {
            temp = new BufferedReader(new FileReader(FILENAME));
        } catch (FileNotFoundException e) {
            temp = null;
        }
        READER = temp;
    }

    private final static FileWriter FILE_WRITER;

    static {
        try {
            FILE_WRITER = new FileWriter(FILENAME, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final static BufferedWriter WRITER = new BufferedWriter(FILE_WRITER);

    public DiskMap() {
        if (READER == null) {
            return;
        }
        try {
            String line = READER.readLine();
            while (line != null) {
                addPair(line);
                line = READER.readLine();
            }
            READER.close();
        } catch (IOException e) {
            LOGGER.info("DiskMap(): " + e.getMessage());
        }
    }

    @Override
    public int size() {
        return MAP.size();
    }

    @Override
    public boolean isEmpty() {
        return MAP.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return MAP.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return MAP.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return MAP.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String returned = MAP.put(key, value);
        String error = "DiskMap.put(): ";
        if (returned != null) {
            if (returned.equals(value)) {
                return returned;
            }
            try {
                rewriteFile();
            } catch (IOException e) {
                LOGGER.info(error + e.getMessage());
            }
        }

        try {
            String line = key + ":" + value + "\n";
            WRITER.append(line);
            WRITER.flush();
        } catch (IOException e) {
            LOGGER.info(error + e.getMessage());
        }
        return returned;
    }

    @Override
    public String remove(Object key) {
        String returned = MAP.remove(key);
        try {
            rewriteFile();
        } catch (IOException e) {
            LOGGER.info("DiskMap.remove(): " + e.getMessage());
        }
        return returned;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        MAP.putAll(m);
    }

    @Override
    public void clear() {
        try {
            new FileWriter(FILENAME, false).close();
        } catch (IOException ignored) {
        }
        MAP.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return MAP.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return MAP.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return MAP.entrySet();
    }

    private void addPair(String line) {
        String[] split = line.split(":");
        MAP.put(split[0], split[1]);
    }

    private void rewriteFile() throws IOException {
        new FileWriter(FILENAME, false).close();
        for (Entry<String, String> entry : MAP.entrySet()) {
            String line = entry.getKey() + ":" + entry.getValue() + "\n";
            WRITER.append(line);
        }
    }
}
