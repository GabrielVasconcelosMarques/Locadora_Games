package locadora_games.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import locadora_games.util.ConstantesUtil;


public class FabricaConexao {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(ConstantesUtil.LOCADORA_GAMES_DATABASE_PATH + "//" + ConstantesUtil.LOCADORA_GAMES_DATABASE_IP + ":" + ConstantesUtil.LOCADORA_GAMES_DATABASE_PORT + "/" + ConstantesUtil.LOCADORA_GAMES_DATABASE_NAME, "postgres", "1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}