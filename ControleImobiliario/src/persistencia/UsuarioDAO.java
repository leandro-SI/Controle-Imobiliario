package persistencia;

import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public interface UsuarioDAO {
    
    public Usuario buscarUsuario(String user, String pass);
    public boolean cadastrarUsuario(Usuario usuario);
}
