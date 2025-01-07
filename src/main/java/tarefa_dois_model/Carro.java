package tarefa_dois_model;

public class Carro extends Model {
    private String placa;
    private String modelo;
    private int ano;

    public Carro(int id, String descricao, double preco, String placa, String modelo, int ano) {
        super(id, descricao, preco);
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
