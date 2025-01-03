package tarefa1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArraySimulador {

    private static final Logger logger = LoggerFactory.getLogger(ArraySimulador.class);

    public int[][] criarArrayBidimensional(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            logger.error("Falha ao criar array: As dimensões do array devem ser maiores que zero.");
            throw new IllegalArgumentException();
        }
        return new int[linhas][colunas];
    }

    public void inserirValor(int[][] matriz, int linha, int coluna, int valor) {
        if (matriz == null) {
            logger.error("Falha ao inserir valor: A matriz não pode ser nula.");
            throw new IllegalArgumentException();
        }
        if (linha < 0 || linha >= matriz.length || coluna < 0 || coluna >= matriz[linha].length) {
            logger.error("Falha ao inserir valor: Índices fora do limite da matriz.");
            throw new ArrayIndexOutOfBoundsException();
        }
        matriz[linha][coluna] = valor;
    }

    public int acessarValor(int[][] matriz, int linha, int coluna) {
        if (matriz == null) {
            logger.error("Falha ao acessar valor: A matriz não pode ser nula.");
            throw new IllegalArgumentException();
        }
        if (linha < 0 || linha >= matriz.length || coluna < 0 || coluna >= matriz[linha].length) {
            logger.error("Falha ao acessar valor: Índices fora do limite da matriz.");
            throw new ArrayIndexOutOfBoundsException();
        }
        return matriz[linha][coluna];
    }
}
