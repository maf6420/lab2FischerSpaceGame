import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MySQLHP {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/stats";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public MySQLHP() {

    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            //MySQL Creates player stats
            insertPlayerStats(connection, 20, 20, 20);

            // MySQL Read
            List<Player> stats = getAllStats(connection);
            for (Player stat : stats) {
                System.out.println(stat);
            }


            //MySQL Updates health stat
            updateStats(connection, 10, 20);

            //MySQL Read again
            stats = getAllStats(connection);
            for (Player stat : stats) {
                System.out.println(stat);
            }

            //MySQL Delete
            deleteHealth(connection, 20);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteHealth(Connection connection, int health) throws SQLException {
        String sql = "DELETE FROM PlayerStats WHERE health = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, health);
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
                stats.add(new Player(ammo, health, speed));
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
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // MongoDB Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("Player");
            MongoCollection<Document> collection = database.getCollection("PStats");

            // MongoDB Insert stats
            Document newPlayer = new Document("Ammo", 20)
                    .append("Health", 20)
                    .append("Speed", 20);
            collection.insertOne(newPlayer);

            // MongoDB Read stats
            FindIterable<Document> PStats = collection.find();
            for (Document player : PStats) {
                System.out.println(player.toJson());

            }
            // MongoDB Update health, lowers HP
            Document updatedPlayer = new Document("$set", new Document("Health", 10));
            collection.updateOne(new Document("Health", 20), updatedPlayer);

            // MongoDB Read stats again after updating HP
            PStats = collection.find();
            for (Document player : PStats) {
                System.out.println(player.toJson());
            }
            // MongoDB Delete
            collection.deleteOne(new Document("Health", 20));
        }

    }
}