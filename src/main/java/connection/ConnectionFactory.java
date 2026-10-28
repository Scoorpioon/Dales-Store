package connection;

// Leitura do db.props

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// banco

public class ConnectionFactory {
    public Connection connect() throws SQLException {
        Properties props = new Properties();
        Path file = Path.of(System.getProperty("user.home"), "pd", "conf", "db.properties");

        try (FileInputStream in = new FileInputStream(file.toFile())) {
            props.load(in);
        } catch (IOException error) {
            throw new SQLException("Error reading db.properties:", error);
        }

        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

    public boolean testConnection() {
        try(Connection connection = connect()) {
            return connection.isValid(3); // connection timeout
        } catch(SQLException error) {
            System.err.println(error.getMessage());
            return false;
        }
    }
}