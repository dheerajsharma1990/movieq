package com.movieq.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SQLFile implements Comparable<SQLFile> {

    private final int majorVersion;

    private final int minorVersion;

    private final Path sqlFilePath;

    public SQLFile(Path sqlFilePath) {
        String fileName = sqlFilePath.toFile().getName();
        String majorMinorVersions = fileName.substring(0, fileName.indexOf('_'));
        String[] split = majorMinorVersions.split("\\.");
        this.majorVersion = Integer.valueOf(split[0]);
        this.minorVersion = Integer.valueOf(split[1]);
        this.sqlFilePath = sqlFilePath;
    }

    public List<String> getAllSQLs() throws IOException {
        return Files.readAllLines(sqlFilePath);
    }

    @Override
    public int compareTo(SQLFile other) {
        return majorVersion == other.majorVersion ? minorVersion - other.minorVersion : majorVersion - other.majorVersion;
    }
}
