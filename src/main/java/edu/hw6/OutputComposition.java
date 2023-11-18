package edu.hw6;

import java.io.*;
import java.nio.file.Files;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class OutputComposition {
	private final static Logger LOGGER = Logger.getLogger("Logger");

	public static boolean writeToFile(String filename, String text) throws IOException {
		File file = new File(filename);
		if (!file.createNewFile()) {
			LOGGER.info("File already exists!");
			return false;
		}
		try (OutputStream stream = Files.newOutputStream(file.toPath())) {
			CheckedOutputStream checked = new CheckedOutputStream(stream, new Adler32());
			BufferedOutputStream buffered = new BufferedOutputStream(checked);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(buffered);
			PrintWriter print = new PrintWriter(outputStreamWriter);
			print.print(text);
			outputStreamWriter.flush();
			buffered.flush();
			checked.flush();
			stream.flush();
			return true;
		}
	}
}