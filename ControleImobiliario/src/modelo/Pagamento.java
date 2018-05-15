package modelo;

import java.sql.Date;

/**
 *
 * @author Alunodev06
 */
public class Pagamento {
    
    private int codPagamento;
    private Date dataPagamento;
    private double valorPagamento;

    
    
    
    
    public Pagamento() {
    }

    public int getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(int codPagamento) {
        this.codPagamento = codPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
    
    
    
    
}
