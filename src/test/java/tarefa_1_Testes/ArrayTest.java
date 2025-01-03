package tarefa_1_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa1.ArraySimulador;

class ArrayTest {

    private Random gerador;
    private static final int TAMANHO = 10;
    private static final int LINHAS = 5;
    private static final int COLUNAS = 6;

    @BeforeEach
    void configurar() {
        gerador = new Random();
    }

    @Test
    void testarArrayUnidimensionalComNumeros() {
        int[] numeros = new int[TAMANHO];
        preencherArrayComValores(numeros, TAMANHO);
        assertEquals(TAMANHO, numeros.length);

        int indiceTeste = 5;
        int valorEsperado = 999;
        numeros[indiceTeste] = valorEsperado;
        assertEquals(valorEsperado, numeros[indiceTeste]);
    }

    @Test
    void testarArrayUnidimensionalComLetras() {
        char[] letras = new char[TAMANHO];
        preencherArrayComValores(letras, TAMANHO);
        assertEquals(TAMANHO, letras.length);

        char letraEsperada = 'Z';
        letras[3] = letraEsperada;
        assertEquals(letraEsperada, letras[3]);
    }

    @Test
    void testarArrayBidimensional() {
        int[][] matriz = new int[LINHAS][COLUNAS];
        preencherMatrizComValores(matriz, LINHAS, COLUNAS);
        assertEquals(LINHAS, matriz.length);

        int valorEsperado = 999;
        int linhaAlvo = 2;
        int colunaAlvo = 3;
        matriz[linhaAlvo][colunaAlvo] = valorEsperado;
        assertEquals(valorEsperado, matriz[linhaAlvo][colunaAlvo]);
    }

    @Test
    void testarArrayVazio() {
        int[] arrayVazio = new int[0];
        assertEquals(0, arrayVazio.length);
    }

    @Test
    void testarRedimensionamentoArray() {
        int[] numeros = new int[5];
        numeros = new int[10];
        assertEquals(10, numeros.length);
    }

    @Test
    void testarFalhaArrayUnidimensionalComNumeros_OutOfBounds() {
        int[] numeros = new int[TAMANHO];

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            numeros[TAMANHO] = 1;
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            numeros[-1] = 1;
        });
    }

    @Test
    void testarFalhaArrayUnidimensionalComLetras_OutOfBounds() {
        char[] letras = new char[TAMANHO];

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            letras[TAMANHO] = 'A';
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            letras[-1] = 'B';
        });
    }

    @Test
    void testarFalhaArrayBidimensional_OutOfBounds() {
        int[][] matriz = new int[LINHAS][COLUNAS];

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            matriz[LINHAS][COLUNAS] = 1;
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { 
            matriz[-1][0] = 1;
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            matriz[0][-1] = 1;
        });
    }

    @Test
    void testarFalhaInserirValorEmArrayNulo_IllegalArgument() {
        int[][] matrizNula = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new ArraySimulador().inserirValor(matrizNula, 0, 0, 42);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ArraySimulador().acessarValor(matrizNula, 0, 0);
        });
    }

    @Test
    void testarFalhaCriarArrayComDimensoesInvalidas_IllegalArgument() {
        ArraySimulador simulador = new ArraySimulador();

        assertThrows(IllegalArgumentException.class, () -> simulador.criarArrayBidimensional(0, 5));
        assertThrows(IllegalArgumentException.class, () -> simulador.criarArrayBidimensional(-1, 3));
    }

    private void preencherArrayComValores(int[] array, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            array[i] = gerador.nextInt(100);
        }
    }

    private void preencherArrayComValores(char[] array, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            array[i] = (char) ('A' + gerador.nextInt(26));
        }
    }

    private void preencherMatrizComValores(int[][] matriz, int linhas, int colunas) {
        for (int index = 0; index < linhas * colunas; index++) {
            int linha = index / colunas;
            int coluna = index % colunas;
            matriz[linha][coluna] = gerador.nextInt(100);
        }
    }
}
