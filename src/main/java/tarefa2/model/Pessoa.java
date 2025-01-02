package tarefa2.model;

public class Pessoa extends Model {
    private String nome;

    public Pessoa(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + getId() + ", nome='" + nome + "'}";
    }
}
