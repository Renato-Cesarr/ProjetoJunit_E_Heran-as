package tarefa_2_e_3_Testes;

import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Model;
import tarefa2.model.Pessoa;

public enum EnumArrayMetodosTest {
    PESSOA_1(new Pessoa(1, "Pessoa 1", 1000.0, "Rua A", 25, "Rua A")),
    PESSOA_2(new Pessoa(2, "Pessoa 2", 1200.0, "Rua B", 30, "Rua B")),
    CARRO_1(new Carro(4, "Carro 1", 20000.0, "ABC-1234", "Fusca", 1980)),
    CARRO_2(new Carro(5, "Carro 2", 25000.0, "XYZ-5678", "Gol", 2000)),
    BICICLETA_1(new Bicicleta(2, "Bicicleta 1", 500.0, "Azul", 18, "Freio a disco")),
    BICICLETA_2(new Bicicleta(3, "Bicicleta 2", 600.0, "Vermelha", 21, "Freio a tambor")),
    PESSOA_INVALIDA(new Pessoa(-1, "Pessoa Inválida", -1.0, "Rua X", -1, "Rua Y"));

    private final Model model;

    EnumArrayMetodosTest(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}
