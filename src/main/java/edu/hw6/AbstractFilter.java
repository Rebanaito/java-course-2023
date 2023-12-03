package edu.hw6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    int MAGIC_SIZE = 4;

    default AbstractFilter and(AbstractFilter anotherFilter) {
        return path -> this.accept(path) && anotherFilter.accept(path);
    }

    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readable() {
        return Files::isReadable;
    }

    static AbstractFilter writeable() {
        return Files::isWritable;
    }

    static AbstractFilter largerThan(int size) {
        return (path -> Files.size(path) > size);
    }

    static AbstractFilter smallerThan(int size) {
        return (path -> Files.size(path) < size);
    }

    static AbstractFilter globMatches(String pattern) {
        return path -> FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern)
                .matches(path.getFileName());
    }

    static AbstractFilter regexContains(String regex) {
        return path -> path.toString().contains(regex);
    }

    static AbstractFilter magicNumber(byte... magic) {
        return path -> {
            if (path.toFile().isFile()) {
                return Arrays.equals(
                        ByteBuffer.allocate(MAGIC_SIZE)
                                .putInt(new DataInputStream(
                                        new FileInputStream(path.toFile()))
                                        .readInt())
                                .array(),
                        magic);
            }
            return false;
        };
    }
}
