package tarefa_um;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArraySimulador {

    private static final Logger logger = LoggerFactory.getLogger(ArraySimulador.class);

    public int[][] criarArrayBidimensional(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            logger.error("Falha ao criar array: As dimensões do array devem ser maiores que zero.");
            throw new IllegalArgumentException("Dimensões inválidas.");
        }
        return new int[linhas][colunas];
    }

    public void inserirValor(int[][] matriz, int linha, int coluna, int valor) {
        validarArrayBidimensional(matriz, linha, coluna);
        matriz[linha][coluna] = valor;
    }

    private void validarArrayBidimensional(Object matriz, int linha, int coluna) {
        if (matriz == null) {
            logger.error("A matriz não pode ser nula.");
            throw new IllegalArgumentException("Matriz nula.");
        }
    }
}
