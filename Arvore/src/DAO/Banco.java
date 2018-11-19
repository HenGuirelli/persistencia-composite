package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Banco {
    // variaveis internas
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String servidor = "localhost";
    private static final String bd = "arvore";
    private static final int porta = 3306;
    
    // variaveis de banco
    private static Connection conexao;
    
    private static ResultSet rs;
    
    public static void conectar() 
            throws ClassNotFoundException, 
                   SQLException {
        String url="jdbc:mysql://" + servidor +
                   ":" + porta +
                   "/" + bd;
     
        //carregar o driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Conectar ao banco
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    //Devolve a conexão criada para o usuario
    public static Connection getConexao() {
        return conexao;
    }
    
    public static void desconectar() 
            throws SQLException {
        conexao.close();
    }
    
    public static void executeUpdate(String sql)
        throws SQLException, ClassNotFoundException {
        Banco.conectar();
        PreparedStatement pst = Banco.getConexao().prepareStatement(sql);
        pst.executeUpdate();
        Banco.desconectar();
    }
}