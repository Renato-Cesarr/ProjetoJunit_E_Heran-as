package tarefa3;

import java.util.Arrays;

import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Model;
import tarefa2.model.Pessoa;

public class ArrayMetodos {

    private Model[] itens;

    public ArrayMetodos(int tamanho) {
        this.itens = new Model[tamanho];
    }

    public Model[] getItens() {
        return itens;
    }
 
    public boolean inserir(int posicao, Model modelo) {
        if (posicao >= 0 && posicao < itens.length && modelo != null) {
            if (modelo instanceof Pessoa || modelo instanceof Bicicleta || modelo instanceof Carro) {
                itens[posicao] = modelo;
                return true;
            }
        } 
        return false;
    }

    public boolean remover(Model modelo) {
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null && itens[i].getId() == modelo.getId()) {
                itens[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean pesquisar(Model modelo) {
        for (Model item : itens) {
            if (item != null && item.getId() == modelo.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean atualizar(int posicao, Model modelo) {
        if (posicao >= 0 && posicao < itens.length && modelo != null && itens[posicao] != null) {
            itens[posicao] = modelo;
            return true;
        }
        return false;
    }
    public void ordenarPorIdCrescente() {
        Arrays.sort(itens, (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return 1;
            return Integer.compare(a.getId(), b.getId());
        });
    }

    public void ordenarPorIdDecrescente() {
        Arrays.sort(itens, (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return 1;
            return Integer.compare(b.getId(), a.getId());
        });
    }

}
