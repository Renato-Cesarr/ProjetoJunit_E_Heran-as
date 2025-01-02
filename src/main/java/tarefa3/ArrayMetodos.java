package tarefa3;

import java.util.Arrays;
import java.util.Random;

import tarefa2.model.Model;

class ArrayMetodos {

    private Model[] itens;

    public ArrayMetodos(int tamanho) {
        this.itens = new Model[tamanho];
    }

    public Model[] getItens() {
        return itens;
    }
    
    public boolean inserir(int posicao, Model modelo) {
        if (posicao >= 0 && posicao < itens.length) {
            itens[posicao] = modelo;
            return true;
        }
        return false;
    }
    
    public void ordenarPorIdCrescente() {
        Arrays.sort(itens, (a, b) -> a.getId() - b.getId());
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
        if (posicao >= 0 && posicao < itens.length && itens[posicao] != null) {
            itens[posicao] = modelo;
            return true;
        }
        return false;
    }
    public void ordenarPorIdDecrescente() {
        Arrays.sort(itens, (a, b) -> b.getId() - a.getId());
    }

}
