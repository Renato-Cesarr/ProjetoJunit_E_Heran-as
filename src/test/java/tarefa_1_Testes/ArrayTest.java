package tarefa_1_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa_um.ArraySimulador;

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
        preencherArrayComValores(numeros);
        assertEquals(TAMANHO, numeros.length);
        int indiceTeste = 5;
        int valorEsperado = 999;
        numeros[indiceTeste] = valorEsperado;
        assertEquals(valorEsperado, numeros[indiceTeste]);
    }

    @Test
    void testarArrayUnidimensionalComLetras() {
        char[] letras = new char[TAMANHO];
        preencherArrayComLetras(letras);
        assertEquals(TAMANHO, letras.length);
        char letraEsperada = 'Z';
        letras[3] = letraEsperada;
        assertEquals(letraEsperada, letras[3]);
    }

    @Test
    void testarArrayBidimensionalComNumeros() {
        int[][] matriz = new int[LINHAS][COLUNAS];
        preencherMatrizComNumeros(matriz);
        int valorEsperado = 999;
        int linhaAlvo = 2;
        int colunaAlvo = 3;
        matriz[linhaAlvo][colunaAlvo] = valorEsperado;
        assertEquals(valorEsperado, matriz[linhaAlvo][colunaAlvo]);
    }

    @Test
    void testarArrayBidimensionalComLetras() {
        char[][] matriz = new char[LINHAS][COLUNAS];
        preencherMatrizComLetras(matriz);
        char letraEsperada = 'Z';
        int linhaAlvo = 2;
        int colunaAlvo = 3;
        matriz[linhaAlvo][colunaAlvo] = letraEsperada;
        assertEquals(letraEsperada, matriz[linhaAlvo][colunaAlvo]);
    }

    @Test
    void testarArrayBidimensionalComNumeros1D() {
        int[][] matriz = new int[LINHAS][COLUNAS];
        int[] numeros1D = new int[COLUNAS];
        preencherArrayComValores(numeros1D);
        for (int i = 0; i < COLUNAS; i++) {
            matriz[2][i] = numeros1D[i];
        }
        for (int i = 0; i < COLUNAS; i++) {
            assertEquals(numeros1D[i], matriz[2][i]);
        }
    }

    @Test
    void testarArrayBidimensionalComLetras1D() {
        char[][] matriz = new char[LINHAS][COLUNAS];
        char[] letras1D = new char[COLUNAS];
        preencherArrayComLetras(letras1D);
        for (int i = 0; i < COLUNAS; i++) {
            matriz[2][i] = letras1D[i];  
        }
        for (int i = 0; i < COLUNAS; i++) {
            assertEquals(letras1D[i], matriz[2][i]);
        }
    }

    @Test
    void testarFalhaArrayUnidimensionalComNumeros_OutOfBounds() {
        int[] numeros = new int[TAMANHO];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> numeros[TAMANHO] = 1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> numeros[-1] = 1);
    }

    @Test
    void testarFalhaArrayUnidimensionalComLetras_OutOfBounds() {
        char[] letras = new char[TAMANHO];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> letras[TAMANHO] = 'A');
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> letras[-1] = 'B');
    }

    @Test
    void testarFalhaArrayBidimensional_OutOfBounds() {
        int[][] matriz = new int[LINHAS][COLUNAS];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz[LINHAS][COLUNAS] = 1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz[-1][0] = 1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz[0][-1] = 1);
    }

    @Test
    void testarFalhaInserirValorEmArrayNulo_IllegalArgumentException() {
        int[][] matrizNula = null;
        ArraySimulador simulador = new ArraySimulador();
        assertThrows(IllegalArgumentException.class, () -> simulador.inserirValor(matrizNula, 0, 0, 42));
    }

    @Test
    void testarFalhaCriarArrayComDimensoesInvalidas_IllegalArgumentException() {
        ArraySimulador simulador = new ArraySimulador();
        assertThrows(IllegalArgumentException.class, () -> simulador.criarArrayBidimensional(0, 5));
        assertThrows(IllegalArgumentException.class, () -> simulador.criarArrayBidimensional(-1, 3));
    }

    private void preencherArrayComValores(int[] array) {
        for (int indice = 0; indice < array.length; indice++) {
            array[indice] = gerador.nextInt(100);
        }
    }

    private void preencherArrayComLetras(char[] array) {
        for (int indice = 0; indice < array.length; indice++) {
            array[indice] = (char) ('A' + gerador.nextInt(26));
        }
    }

    private void preencherMatrizComNumeros(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = gerador.nextInt(100);
            }
        }
    }

    private void preencherMatrizComLetras(char[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = (char) ('A' + gerador.nextInt(26));
            }
        }
    }
}
