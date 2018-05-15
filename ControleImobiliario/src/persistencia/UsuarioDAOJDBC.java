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
                usuarioProcurado.setNome(resultado.getString("nome"));
                usuarioProcurado.setLogin(resultado.getString("login"));
                usuarioProcurado.setSenha(resultado.getString("senha"));
                
                return usuarioProcurado;
                
            }else{
                
                return null;
            }// fim do else
            
        }catch(SQLException msg){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados" + msg.getMessage());
        }// fim catch;
        
        return usuarioProcurado;
    }// fim do método buscarUsuario
    
    public boolean cadastrarUsuario(Usuario usuario){
        
        String consulta = "INSERT INTO usuario(nome, login, senha) VALUES(?, ?, ?)";
        boolean status = false;
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.executeUpdate();
            stmt.close();
            status = true;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro no cadastro de usuário!");
        }// fim catch;
        
        return status;
    }// fim metodo cadastrarUsuario;
    
    
}
