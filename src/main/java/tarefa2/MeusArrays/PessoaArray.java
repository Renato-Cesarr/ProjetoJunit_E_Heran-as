package tarefa2.MeusArrays;

import java.util.Arrays;

import tarefa2.model.Model;
import tarefa2.model.Pessoa;

public class PessoaArray {
    private Model[] itens;

    public PessoaArray(int tamanho) {
        this.itens = new Model[tamanho];
    }

    public boolean inserir(int posicao, Model modelo) {
        if (modelo instanceof Pessoa && posicao >= 0 && posicao < itens.length) {
            itens[posicao] = modelo;
            return true;
        }
        return false;
    }

    public boolean remover(Model modelo) {
        if (modelo instanceof Pessoa) {
            for (int i = 0; i < itens.length; i++) {
                if (itens[i] != null && itens[i].getId() == modelo.getId()) {
                    itens[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pesquisar(Model modelo) {
        if (modelo instanceof Pessoa) {
            for (Model item : itens) {
                if (item != null && item.getId() == modelo.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ordenarPorIdCrescente() {
        Arrays.sort(itens, (a, b) -> {
            if (a instanceof Pessoa && b instanceof Pessoa) {
                return Integer.compare(a.getId(), b.getId());
            }
            return 0;
        });
    }

    public void ordenarPorIdDecrescente() {
        Arrays.sort(itens, (a, b) -> {
            if (a instanceof Pessoa && b instanceof Pessoa) {
                return Integer.compare(b.getId(), a.getId());
            }
            return 0;
        });
    }

    public boolean atualizar(int posicao, Model modelo) {
        if (modelo instanceof Pessoa && posicao >= 0 && posicao < itens.length && itens[posicao] != null) {
            itens[posicao] = modelo;
            return true;
        }
        return false;
    }
}
