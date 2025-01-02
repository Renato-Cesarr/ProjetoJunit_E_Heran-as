package tarefa2.MeusArrays;

import tarefa2.model.Carro;

public class CarroArray {

    private Carro[] itens;
    private int tamanho;

    public CarroArray(int capacidade) {
        itens = new Carro[capacidade];
        tamanho = 0;
    }

    public boolean inserir(int posicao, Carro carro) {
        if (posicao < 0 || posicao >= itens.length || carro == null) {
            return false;
        }
        itens[posicao] = carro;
        tamanho++;
        return true;
    }

    public boolean remover(Carro carro) {
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null && itens[i].equals(carro)) {
                itens[i] = null;
                tamanho--;
                return true;
            }
        }
        return false;
    }

    public boolean pesquisar(Carro carro) {
        for (Carro c : itens) {
            if (c != null && c.equals(carro)) {
                return true;
            }
        }
        return false;
    }

    public boolean atualizar(int posicao, Carro carro) {
        if (posicao < 0 || posicao >= itens.length || carro == null || itens[posicao] == null) {
            return false;
        }
        itens[posicao] = carro;
        return true;
    }

    public void ordenarPorIdCrescente() {
        for (int i = 0; i < itens.length - 1; i++) {
            for (int j = i + 1; j < itens.length; j++) {
                if (itens[i] != null && itens[j] != null && itens[i].getId() > itens[j].getId()) {
                    Carro temp = itens[i];
                    itens[i] = itens[j];
                    itens[j] = temp;
                }
            }
        }
    }

    public void ordenarPorIdDecrescente() {
        for (int i = 0; i < itens.length - 1; i++) {
            for (int j = i + 1; j < itens.length; j++) {
                if (itens[i] != null && itens[j] != null && itens[i].getId() < itens[j].getId()) {
                    Carro temp = itens[i];
                    itens[i] = itens[j];
                    itens[j] = temp;
                }
            }
        }
    }

    public Carro[] getItens() {
        return itens;
    }
}
