package tarefa2.MeusArrays;

import java.util.logging.Level;
import java.util.logging.Logger;

import tarefa2.model.Bicicleta;
import tarefa2.model.Model;
import tarefa3.ArrayMetodos;

public class BicicletaArray extends ArrayMetodos {
    private static final Logger LOGGER = Logger.getLogger(BicicletaArray.class.getName());

    public BicicletaArray(int tamanho) {
        super(tamanho);
    }
 
    @Override
    public boolean inserir(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Bicicleta)) {
                throw new IllegalArgumentException("Somente objetos do tipo Bicicleta podem ser adicionados.");
            }
            return super.inserir(posicao, modelo);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean remover(Model modelo) {
        try {
            if (!(modelo instanceof Bicicleta)) {
                throw new IllegalArgumentException("Somente objetos do tipo Bicicleta podem ser removidos.");
            }
            return super.remover(modelo);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean pesquisar(Model modelo) {
        try {
            if (!(modelo instanceof Bicicleta)) {
                throw new IllegalArgumentException("Somente objetos do tipo Bicicleta podem ser pesquisados.");
            }
            return super.pesquisar(modelo);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean atualizar(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Bicicleta)) {
                throw new IllegalArgumentException("Somente objetos do tipo Bicicleta podem ser atualizados.");
            }
            return super.atualizar(posicao, modelo);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw e;
        }
    }
}
