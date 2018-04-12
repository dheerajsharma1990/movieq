package com.movieq.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Runner {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/movieq", "sa", "");
        Path sqlDirectoryPath = Paths.get(H2Runner.class.getClassLoader().getResource("sql").toURI());
        connection.prepareStatement("DROP ALL OBJECTS").execute();

        Files.walk(sqlDirectoryPath)
                .filter(path -> path.toFile().getName().endsWith(".sql"))
                .map(SQLFile::new)
                .sorted()
                .forEach(sqlFile -> {
                    try {
                        sqlFile.getAllSQLs()
                                .forEach(sql -> {
                                    try {
                                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                                        boolean executionResult = preparedStatement.execute();
                                        preparedStatement.close();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        connection.close();
    }
}