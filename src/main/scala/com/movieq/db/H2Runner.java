package com.movieq.db;

import org.h2.tools.Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Runner {

    private static final String MOVIEQ_DB_PATH = "./target/movieqdb";

    public static void main(String[] args) throws Exception {
        Server server = Server.createTcpServer(new String[]{"-tcpAllowOthers"}).start();
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/" + MOVIEQ_DB_PATH, "sa", "");
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
                                        preparedStatement.executeUpdate();
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
        server.stop();
    }
}
