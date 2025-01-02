package tarefa2.MeusArrays;

import tarefa2.model.Bicicleta;

public class BicicletaArray {

    private Bicicleta[] itens;
    private int tamanho;

    public BicicletaArray(int capacidade) {
        itens = new Bicicleta[capacidade];
        tamanho = 0;
    }

    public boolean inserir(int posicao, Bicicleta bicicleta) {
        if (posicao < 0 || posicao >= itens.length || bicicleta == null) {
            return false;
        }
        itens[posicao] = bicicleta;
        tamanho++;
        return true;
    }

    public boolean remover(Bicicleta bicicleta) {
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null && itens[i].equals(bicicleta)) {
                itens[i] = null;
                tamanho--;
                return true;
            }
        }
        return false;
    }

    public boolean pesquisar(Bicicleta bicicleta) {
        for (Bicicleta b : itens) {
            if (b != null && b.equals(bicicleta)) {
                return true;
            }
        }
        return false;
    }

    public boolean atualizar(int posicao, Bicicleta bicicleta) {
        if (posicao < 0 || posicao >= itens.length || bicicleta == null || itens[posicao] == null) {
            return false;
        }
        itens[posicao] = bicicleta;
        return true;
    }

    public void ordenarPorIdCrescente() {
        for (int i = 0; i < itens.length - 1; i++) {
            for (int j = i + 1; j < itens.length; j++) {
                if (itens[i] != null && itens[j] != null && itens[i].getId() > itens[j].getId()) {
                    Bicicleta temp = itens[i];
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
                    Bicicleta temp = itens[i];
                    itens[i] = itens[j];
                    itens[j] = temp;
                }
            }
        }
    }

    public Bicicleta[] getItens() {
        return itens;
    }
}
