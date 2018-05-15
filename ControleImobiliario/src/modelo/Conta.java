package modelo;

import java.sql.Date;

/**
 *
 * @author Alunodev06
 */
public class Conta {
    
    private int codConta;
    private Date dataConta;
    private double valorConta;

    
    
    
    public Conta() {
    }

    public int getCodConta() {
        return codConta;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public Date getDataConta() {
        return dataConta;
    }

    public void setDataConta(Date dataConta) {
        this.dataConta = dataConta;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }
    
    
    
    
}
