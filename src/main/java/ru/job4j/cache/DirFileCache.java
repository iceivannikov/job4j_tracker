package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path path = Path.of(cachingDir, key);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File not found: " + path);
        }
        if (!Files.isReadable(path)) {
            throw new IllegalArgumentException("No read access to file: " + path);
        }
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
    }
}
