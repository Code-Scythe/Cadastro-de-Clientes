package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static final String URL = "jdbc:mysql://localhost:3306/CLIENTES_DB";
    private static Connection conexao = null;
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        if (conexao == null) {
            Class dbDriver = Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, "", "");
        }
        return conexao;
    }
}
