/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ClienteDAOJDBC extends DAOBaseJDBC implements ClienteDAO{
    
    
    public boolean CadastrarCliente(Cliente cliente){
        
        String consulta = "INSERT INTO cliente(nome, cpf, rg, sexo, estadoCivil, "
                + "telefone, celular, email, tipo, status, observacao) VALUES(?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ? ,?)"; // Incluir interrogação da coluna dataNascimento;
        boolean status = false;
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, cliente.getNome()); // coluna Nome;
            stmt.setString(2, cliente.getCpf()); // colune Cpf;
            stmt.setString(3, cliente.getRg()); // coluna Rg;
            SimpleDateFormat atual = new SimpleDateFormat("yyyy/MM/dd");
            //stmt.setDate(4, atual.parse(cliente.getDataNascimento())); // coluna dataNascimento;
            stmt.setString(4, cliente.getSexo());
            
            if(!cliente.getEstadoCivil().isEmpty()){
                stmt.setString(5, cliente.getEstadoCivil());
            }else{
                stmt.setString(5, null);
            }
            
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getCelular());
            
            if(!cliente.getEmail().isEmpty()){
                stmt.setString(8, cliente.getEmail());
            }else{
                stmt.setString(8, null);
            }
            
            stmt.setString(9, cliente.getTipo());
            stmt.setString(10, "ativo");
            
            if(!cliente.getObservacao().isEmpty()){
                stmt.setString(11, cliente.getObservacao());
            }else{
                stmt.setString(11, null);
            }
                 
            stmt.executeUpdate();
            status = true;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco cad/cliente");
        }
        
        
        return status;
    }// Fim da classe CadastrarCliente;
    
}
