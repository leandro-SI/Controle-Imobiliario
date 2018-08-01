/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import aplicacao.CadastroImovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Agua;
import modelo.Endereco;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ImovelDAOJDBC extends DAOBaseJDBC implements ImovelDAO {
    
    public boolean CadastrarImovel(CadastroImovel imovel){
        
        boolean status = false;
        
        String consultaSQL = "INSERT INTO imovel(situacao, identificacao, valorAluguel, observacao, "
                + "iptu, proprietario, dataCadastro, Endereco_idEndereco, TipoImovel_idTipoImovel, "
                + "CadLuz_idCadLuz, CadAgua_idCadAgua) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        
        return status;
    }
    
    
    
    public void CadastrarEndereco(Endereco endereco){
        
        String consultaSQL = "INSERT INTO endereco(logradouro, numero, bairro, cidade, estado, cep) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            stmt.setString(1, endereco.getLogradouro());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getCep());
            stmt.executeUpdate();
                    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Endereco: " + e.getMessage());
        }
    }//Fim Método CadastrarEndereco
    
    
    
    
    
    
    
    public int IdUltimoEndereco(){
        
        int id = -1;
        String consultaSQL = "SELECT * FROM endereco ORDER BY  DESC limit 1";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                
                id = resultado.getInt("idEndereco");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no Retorno do ID-Endereco: " + e.getMessage());
        }
        
        return id;
    }
    
    public int idUltimoCadLuz(){
        
        int id = -1;
        String consultaSQL = "SELECT * FROM cadluz ORDER BY  DESC limit 1";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                
                id = resultado.getInt("idCadLuz");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no Retorno do ID-CadLuz: " + e.getMessage());
        }
        
        return id;
    }
    
    
    public int idUltimoCadAgua(){
        
        int id = -1;
        String consultaSQL = "SELECT * FROM cadagua ORDER BY  DESC limit 1";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                
                id = resultado.getInt("idCadAgua");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no Retorno do ID-CadAgua: " + e.getMessage());
        }
        
        return id;
    }
    
}

