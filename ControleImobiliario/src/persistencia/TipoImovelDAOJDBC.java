/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import aplicacao.TipoImovel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class TipoImovelDAOJDBC extends DAOBaseJDBC implements TipoImovelDAO {
    
    public boolean CadastrarTipoImovel(TipoImovel tipo){
        
        String consulta = "INSERT INTO tipoimovel(tipo) VALUES(?)";
        
        boolean status = false;
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, tipo.getName());
            stmt.executeUpdate();
            status = true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return status;
    }
    
}
