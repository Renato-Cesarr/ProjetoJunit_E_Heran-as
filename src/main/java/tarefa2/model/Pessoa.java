package tarefa2.model;

public class Pessoa extends Model {
    private String nome;

    public Pessoa(int id, String nome) {
        super(id);
        this.nome = nome;
    }

}
