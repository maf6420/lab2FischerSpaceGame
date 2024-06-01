import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MySQLHP {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/STATS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public MySQLHP() {

    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            //Creates health stat
            insertPlayerStats(connection, 20, 20,20);

            // Read
            List<Player> stats = getAllStats(connection);
            for (Player stat : stats) {
                System.out.println(stat);
            }


            //Updates health stat
            updateStats(connection, 10,20);

            // Read again
            stats = getAllStats(connection);
            for (Player stat : stats) {
                System.out.println(stat);
            }

            // Delete
            deleteHealth(connection, 20);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteHealth(Connection connection, int speed) throws SQLException {
        String sql = "DELETE FROM PlayerStats WHERE speed = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, speed);
            preparedStatement.executeUpdate();
        }
    }

    private static void updateStats(Connection connection, int newHealth, int speed) throws SQLException {
        String sql = "UPDATE PlayerStats SET health = ? WHERE speed = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newHealth);
            preparedStatement.setInt(2, speed);
            preparedStatement.executeUpdate();
        }
    }

    private static List<Player> getAllStats(Connection connection) throws SQLException {
        List<Player> stats = new ArrayList<>();
        String sql = "SELECT Ammo, Health, Speed FROM PlayerStats";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int ammo = resultSet.getInt("ammo");
                int health = resultSet.getInt("health");
                int speed = resultSet.getInt("speed");
                stats.add(new Player(ammo,health,speed));
            }
        }
        return stats;
    }

    private static void insertPlayerStats(Connection connection, int Ammo, int Health, int Speed) throws SQLException {
        String sql = "INSERT INTO PlayerStats (Ammo, Health,Speed) VALUES (?,?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Ammo);
            preparedStatement.setInt(2, Health);
            preparedStatement.setInt(3, Speed);
            preparedStatement.executeUpdate();
            {
            }
        }
    }
}