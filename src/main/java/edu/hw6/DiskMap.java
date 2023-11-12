package edu.hw6;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class DiskMap implements Map<String, String> {
	private final static Logger LOGGER = Logger.getLogger("LOGGER");
	private final static Map<String, String> map = new HashMap<String, String>();
	private final static String FILENAME = "diskMap.txt";
	private final static BufferedReader reader;

	static {
		BufferedReader temp;
		try {
			temp = new BufferedReader(new FileReader(FILENAME));
		} catch (FileNotFoundException e) {
			temp = null;
		}
		reader = temp;
	}

	private final static FileWriter fileWriter;

	static {
		try {
			fileWriter = new FileWriter(FILENAME, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private final static BufferedWriter writer = new BufferedWriter(fileWriter);

	public DiskMap() {
		if (reader == null) {
			return;
		}
		try {
			String line = reader.readLine();
			while (line != null) {
				addPair(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			LOGGER.info("DiskMap(): " + e.getMessage());
		}
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public String get(Object key) {
		return map.get(key);
	}

	@Nullable
	@Override
	public String put(String key, String value) {
		String returned = map.put(key, value);
		if (returned != null) {
			if (returned.equals(value)) {
				return returned;
			}
			try {
				rewriteFile();
			} catch (IOException e) {
				LOGGER.info("DiskMap.put(): " + e.getMessage());
			}
		}

		try {
			String line = key + ":" + value + "\n";
			writer.append(line);
			writer.flush();
		} catch (IOException e) {
			LOGGER.info("DiskMap.put(): " + e.getMessage());
		}
		return returned;
	}

	@Override
	public String remove(Object key) {
		String returned = map.remove(key);
		try {
			rewriteFile();
		} catch (IOException e) {
			LOGGER.info("DiskMap.remove(): " + e.getMessage());
		}
		return returned;
	}

	@Override
	public void putAll(@NotNull Map<? extends String, ? extends String> m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		try {
			new FileWriter(FILENAME, false).close();
		} catch (IOException ignored) {
		}
		map.clear();
	}

	@NotNull
	@Override
	public Set<String> keySet() {
		return map.keySet();
	}

	@NotNull
	@Override
	public Collection<String> values() {
		return map.values();
	}

	@NotNull
	@Override
	public Set<Entry<String, String>> entrySet() {
		return map.entrySet();
	}

	private void addPair(String line) {
		String[] split = line.split(":");
		map.put(split[0], split[1]);
	}

	private void rewriteFile() throws IOException {
		new FileWriter(FILENAME, false).close();
		for (Entry<String, String> entry : map.entrySet()) {
			String line = entry.getKey() + ":" + entry.getValue() + "\n";
			writer.append(line);
		}
	}
}
