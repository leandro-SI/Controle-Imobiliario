/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cliente;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ClienteDAOJDBC extends DAOBaseJDBC implements ClienteDAO{
    
    
    public boolean CadastrarCliente(Cliente cliente){
        
        String consulta = "INSERT INTO cliente(nome, cpf, rg, dataNascimento, sexo, estadoCivil, "
                + "telefone, celular, email, tipo, status, observacao) VALUES(?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ? ,?)";
        boolean status = false;
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            //stmt.setDate(4, '2018/06/02');
            stmt.setString(5, cliente.getSexo());
            stmt.setString(6, cliente.getEstadoCivil());
            stmt.setString(7, cliente.getTelefone());
            stmt.setString(8, cliente.getCelular());
            stmt.setString(9, cliente.getEmail());  
            stmt.setString(10, "físico");
            stmt.setString(11, "ativo");
            stmt.setString(12, cliente.getObservacao());
            stmt.executeQuery();
            //stmt.close();
            status = true;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco cad/cliente");
        }// Fim do catch;
        
        
        return status;
    }// Fim da classe CadastrarCliente;
    
}
