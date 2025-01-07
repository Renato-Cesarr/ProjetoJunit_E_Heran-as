package tarefa_dois_meus_arrays;

import java.util.logging.Level;
import java.util.logging.Logger;
import tarefa_dois_model.Pessoa;
import tarefa_dois_model.Model;
import tarefa_dois_model.ModelException;
import tarefa_tres.ArrayMetodos;

public class PessoaArray extends ArrayMetodos {
    private static final Logger LOGGER = Logger.getLogger(PessoaArray.class.getName());

    public PessoaArray(int tamanho) {
        super(tamanho);
    }

    @Override
    public boolean inserir(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Pessoa)) {
                throw new ModelException("Somente objetos do tipo Pessoa podem ser adicionados.");
            }
            return super.inserir(posicao, modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean remover(Model modelo) {
        try {
            if (!(modelo instanceof Pessoa)) {
                throw new ModelException("Somente objetos do tipo Pessoa podem ser removidos.");
            }
            return super.remover(modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean pesquisar(Model modelo) {
        try {
            if (!(modelo instanceof Pessoa)) {
                throw new ModelException("Somente objetos do tipo Pessoa podem ser pesquisados.");
            }
            return super.pesquisar(modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean atualizar(int posicao, Model modelo) {
        try {
            if (!(modelo instanceof Pessoa)) {
                throw new ModelException("Somente objetos do tipo Pessoa podem ser atualizados.");
            }
            return super.atualizar(posicao, modelo);
        } catch (ModelException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }
}
