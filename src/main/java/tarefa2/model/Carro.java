package tarefa2.model;

public class Carro extends Model {
    private String placa;

    public Carro(int id, String placa) {
        super(id);
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{id=" + getId() + ", placa='" + placa + "'}";
    }
}
