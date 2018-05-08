/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public interface UsuarioDAO {
    
    public Usuario buscarUsuario(String user, String pass);
}
