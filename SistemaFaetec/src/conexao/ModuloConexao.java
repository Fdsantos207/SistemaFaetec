package conexao;
   
import java.sql.*;


public class ModuloConexao {
    
    //metodo responsavel ppor estabelecer a conexao com o banco
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // a linha abaixo "chama" o drive
        String driver = "com.mysql.cj.jdbc.Driver";
        // armazenando informacoes referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbfenetec?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "root";
        // estabelecendo a conexao com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha a baixo serve de apoio para esclarecer o erro
            //System.out.println(e);
            return null;
        }
        
    }
    
}