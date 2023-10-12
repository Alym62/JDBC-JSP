package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/<Nome do DB>";
    private final String user = "<User>";
    private final String password = "<Password>";

    public Connection conexao(){

        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            System.out.println(e);
            return null;
        }

        return conn;
    }

    // SCRIPT PARA TESTAR CONEXÃO
    /* public void testarConexao(){
        try {
            Connection conn = conexao();
            System.out.println("A conexão foi efetuada com sucesso! 🟢");
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
    } */
}
