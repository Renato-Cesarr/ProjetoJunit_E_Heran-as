package tarefa2.model;

public class Pessoa extends Model {
    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(int id, String descricao, double preco, String nome, int idade, String endereco) {
        super(id, descricao, preco);
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
