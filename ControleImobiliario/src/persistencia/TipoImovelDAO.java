/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import aplicacao.CadastroTipoImovel;
import modelo.TipoImovel;
import java.util.List;

/**
 *
 * @author Leandro
 */
public interface TipoImovelDAO {
    
    public boolean CadastrarTipoImovel(CadastroTipoImovel tipo);
    public List<TipoImovel> ListaTipoImovel();
}
