/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class UsuarioDAOJDBC extends DAOBaseJDBC implements UsuarioDAO{
    
    public Usuario buscarUsuario(String user, String pass){
        
        Usuario usuarioProcurado = null;
        String consulta = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuarioProcurado = new Usuario();
                usuarioProcurado.setCodigoUsuario(resultado.getInt("idUsuario"));
                usuarioProcurado.setLogin(resultado.getString("login"));
                usuarioProcurado.setSenha(resultado.getString("senha"));
                
                return usuarioProcurado;
                
            }else{
                
                return null;
            }
            
        }catch(SQLException msg){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados" + msg.getMessage());
        }
        
        return usuarioProcurado;
    }
    
}
