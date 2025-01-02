package tarefa2.model;

public class Bicicleta extends Model {
    private String cor;

    public Bicicleta(int id, String cor) {
        super(id);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Bicicleta{id=" + getId() + ", cor='" + cor + "'}";
    }
}
