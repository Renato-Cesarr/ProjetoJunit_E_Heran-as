package tarefa_dois_meus_arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

import tarefa_dois_model.Carro;
import tarefa_dois_model.Model;
import tarefa_dois_model.ModelException;
import tarefa_tres.ArrayMetodos;

public class CarroArray extends ArrayMetodos {
    private static final Logger LOGGER = Logger.getLogger(CarroArray.class.getName());

    public CarroArray(int tamanho) {
        super(tamanho);
    }

    @Override
    public boolean inserir(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Carro)) {
                throw new ModelException("Somente objetos do tipo Carro podem ser adicionados.");
            }
            return super.inserir(posicao, modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Erro ao inserir carro.", e);
        }
    }

    @Override
    public boolean remover(Model modelo) {
        try {
            if (!(modelo instanceof Carro)) {
                throw new ModelException("Somente objetos do tipo Carro podem ser removidos.");
            }
            return super.remover(modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Erro ao remover carro.", e);
        }
    }

    @Override
    public boolean pesquisar(Model modelo) {
        try {
            if (!(modelo instanceof Carro)) {
                throw new ModelException("Somente objetos do tipo Carro podem ser pesquisados.");
            }
            return super.pesquisar(modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Erro ao pesquisar carro.", e);
        }
    }

    @Override
    public boolean atualizar(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Carro)) {
                throw new ModelException("Somente objetos do tipo Carro podem ser atualizados.");
            }
            return super.atualizar(posicao, modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Erro ao atualizar carro.", e);
        }
    }
}
