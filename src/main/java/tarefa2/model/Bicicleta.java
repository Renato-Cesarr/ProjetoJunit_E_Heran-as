package tarefa2.model;

public class Bicicleta extends Model {
    private String cor;
    private int marchas;
    private String tipoFreio;

    public Bicicleta(int id, String descricao, double preco, String cor, int marchas, String tipoFreio) {
        super(id, descricao, preco);
        this.cor = cor;
        this.marchas = marchas;
        this.tipoFreio = tipoFreio;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }
}
