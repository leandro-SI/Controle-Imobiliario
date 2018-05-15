package modelo;

/**
 *
 * @author Alunodev06
 */
public class Imovel {
    
    private int codImovel;
    private Endereco endereco;
    private int situacao;
    private TipoImovel tipo;
    private String identificacao;
    private double valorAluguel;
    private String observacao;

    
    
    
    
    public Imovel() {
    }

    public int getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(int codImovel) {
        this.codImovel = codImovel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
       
    
    
    
}
