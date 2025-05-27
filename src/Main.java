import java.sql.Connection;
import java.sql.SQLException;
import com.nicoselomin.gestionLoyer.dao.ConnectionDB;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConnectionDB.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connexion à la base réussie !");
            }
        } catch (SQLException e) {
            System.out.println("❌ Échec de la connexion : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
