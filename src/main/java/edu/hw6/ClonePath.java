package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClonePath {
    private ClonePath() {
    }

    public static Path clonePath(Path path) throws IOException {
        if (!Files.exists(path)) {
            return null;
        }
        Path parent = path.getParent();
        String[] name = path.getFileName().toString().split("\\.");
        if (name.length == 1) {
            return withoutSuffix(path, parent, name[0]);
        }
        return withSuffix(path, parent, name[0], name[1]);
    }

    private static Path withoutSuffix(Path path, Path parent, String name) throws IOException {
        String p = "";
        String copy = " - copy";
        if (parent != null) {
            p = parent + "/";
        }

        if (!Files.exists(Path.of(p + name + copy))) {
            File dest = new File(p + name + copy);
            Files.copy(path, dest.toPath());
            return dest.toPath();
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            String newPath = String.format("%s%s - copy (%d)", p, name, i);
            if (!Files.exists(Path.of(newPath))) {
                File dest = new File(newPath);
                Files.copy(path, dest.toPath());
                return dest.toPath();
            }
        }
        return null;
    }

    private static Path withSuffix(Path path, Path parent, String name, String suffix) throws IOException {
        String p = "";
        String copy = " - copy.";
        if (parent != null) {
            p = parent.toString() + "/";
        }
        File source = new File(path.toString());
        if (!Files.exists(Path.of(p + name + copy + suffix))) {
            File dest = new File(p + name + copy + suffix);
            Files.copy(path, dest.toPath());
            return dest.toPath();
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            String newPath = String.format("%s%s - copy (%d).%s", p, name, i, suffix);
            if (!Files.exists(Path.of(newPath))) {
                File dest = new File(newPath);
                Files.copy(path, dest.toPath());
                return dest.toPath();
            }
        }
        return null;
    }
}
