/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import aplicacao.CadastroImovel;
import modelo.Agua;
import modelo.Endereco;
import modelo.Luz;

/**
 *
 * @author Leandro
 */
public interface ImovelDAO {
    
    public boolean CadastrarImovel(CadastroImovel imovel);
    public void CadastrarEndereco(Endereco endereco);
    //public void CadastrarAgua(Agua agua);
    //public void CadastrarLuz(Luz luz);
    public int IdUltimoEndereco();
    public int idUltimoCadLuz();
    public int idUltimoCadAgua();
}
