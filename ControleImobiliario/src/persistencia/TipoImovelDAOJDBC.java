/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import aplicacao.CadastroTipoImovel;
import modelo.TipoImovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class TipoImovelDAOJDBC extends DAOBaseJDBC implements TipoImovelDAO {
    
    public boolean CadastrarTipoImovel(CadastroTipoImovel tipo){
        
        String consultaSQL = "INSERT INTO tipoimovel(tipo) VALUES(?)";
        
        boolean status = false;
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            stmt.setString(1, tipo.getName());
            stmt.executeUpdate();
            status = true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return status;
    }//FIM METODO CadastrarTipoImovel;
    
    public List<TipoImovel> ListaTipoImovel(){
        
        List<TipoImovel> listaRetornada = null; 
        
        String consultaSQL = "SELECT * FROM tipoimovel";
        
        try{
           PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            ResultSet resultado = stmt.executeQuery();
            listaRetornada = new ArrayList<TipoImovel>();
            
            while(resultado.next()){
                TipoImovel tipo = new TipoImovel();
                tipo.setCodTipoImovel(resultado.getInt("idTipoImovel"));
                tipo.setTipo(resultado.getString("tipo"));
                listaRetornada.add(tipo);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao retornar lista de TipoImovel");
        }
        
        return listaRetornada;
    }
    
}
