package tarefa2.MeusArrays;

import tarefa2.model.Pessoa;

public class PessoaArray {

    private Pessoa[] itens;
    private int tamanho;

    public PessoaArray(int capacidade) {
        itens = new Pessoa[capacidade];
        tamanho = 0;
    }
 
    public boolean inserir(int posicao, Pessoa pessoa) {
        if (posicao < 0 || posicao >= itens.length || pessoa == null) {
            return false;
        }
        itens[posicao] = pessoa;
        tamanho++;
        return true;
    }

    public boolean remover(Pessoa pessoa) {
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null && itens[i].equals(pessoa)) {
                itens[i] = null;
                tamanho--;
                return true;
            }
        }
        return false;
    }

    public boolean pesquisar(Pessoa pessoa) {
        for (Pessoa p : itens) {
            if (p != null && p.equals(pessoa)) {
                return true;
            }
        }
        return false;
    }

    public boolean atualizar(int posicao, Pessoa pessoa) {
        if (posicao < 0 || posicao >= itens.length || pessoa == null || itens[posicao] == null) {
            return false;
        }
        itens[posicao] = pessoa;
        return true;
    }

    public void ordenarPorIdCrescente() {
        for (int i = 0; i < itens.length - 1; i++) {
            for (int j = i + 1; j < itens.length; j++) {
                if (itens[i] != null && itens[j] != null && itens[i].getId() > itens[j].getId()) {
                    Pessoa temp = itens[i];
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
                    Pessoa temp = itens[i];
                    itens[i] = itens[j];
                    itens[j] = temp;
                }
            }
        }
    }

    public Pessoa[] getItens() {
        return itens;
    }
}
