package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Set;
import model.*;

public class ArvoreDAO {
    public static void salvar(XML xml) {
        ArvoreDAO.deletar();
        String resp = xml.getFormattedSQL(null);
        
        String sql = ("insert into arvore values " + resp);
        
        try {
            Banco.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private static void deletar(){
        String sql = ("delete from arvore");
        
        try {
            Banco.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static XML carregar(){
        try{
            Set<Tag> set = new Set<>();
            PreparedStatement pst;
            ResultSet rs;
            String sql = "select * from arvore";
            Banco.conectar();

            pst = Banco.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            Tag node = null;
            Tag anterior = null;
            Tag raiz = null;
            while(rs.next()){
                String nome = rs.getString("nome");
                String conteudo = rs.getString("conteudo");
                int _hash = rs.getInt("_hash");
                boolean isNode = rs.getBoolean("node");
                
                int pai = rs.getInt("pai");
                
                if (pai == 0){
                    // base da arvore
                    node = new Tag();
                    node.setName(nome);
                    set.add(node);
                    raiz = node;
                }else{
                    if (isNode){
                        node = new Tag();
                        node.setName(nome);
                        node.setHashCode(_hash);
                        // adiciona nó no composite
                        set.getByHashCode(pai).add(node);
                        // adiciona nó na estrutura de carregamento
                        set.add(node);
                    }else{
                        set.getByHashCode(pai).add(new Content(conteudo)); 
                    }
                }
            }
            Banco.desconectar();
            return raiz;
        
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
