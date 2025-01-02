package tarefa_1_Testes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;

class ArrayTest {

    private Random gerador;
    private int tamanho;
    private int linhas, colunas;

    @BeforeEach
    void configurar() {
        gerador = new Random();
        tamanho = 10;
        linhas = 5;
        colunas = 5;
    }

    @Test
    void testarArrayUnidimensionalComNumeros() {
        int[] numeros = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            numeros[i] = gerador.nextInt(100);
        }

        assertEquals(tamanho, numeros.length);
        for (int i = 0; i < tamanho; i++) {
            assertTrue(numeros[i] >= 0 && numeros[i] < 100);
        }

        numeros[5] = 999;
        assertEquals(999, numeros[5]);
    }

    @Test
    void testarArrayUnidimensionalComLetras() {
        char[] letras = new char[tamanho];

        for (int i = 0; i < tamanho; i++) {
            letras[i] = (char) ('A' + gerador.nextInt(26));
        }

        assertEquals(tamanho, letras.length);
        for (char letra : letras) {
            assertTrue(letra >= 'A' && letra <= 'Z');
        }

        letras[3] = 'Z';
        assertEquals('Z', letras[3]);
    }

    @Test
    void testarArrayBidimensional() {
        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = gerador.nextInt(100);
            }
        }

        assertEquals(linhas, matriz.length);
        for (int i = 0; i < linhas; i++) {
            assertEquals(colunas, matriz[i].length);
            for (int j = 0; j < colunas; j++) {
                assertTrue(matriz[i][j] >= 0 && matriz[i][j] < 100);
            }
        }

        matriz[2][3] = 999;
        assertEquals(999, matriz[2][3]);
    }

    @Test
    void testarArrayVazio() {
        int[] arrayVazio = new int[0];
        assertEquals(0, arrayVazio.length);
    }

    @Test
    void testarExcecaoArrayForaDeLimite() {
        int[] numeros = new int[tamanho];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int valor = numeros[tamanho];
        });
    }

    @Test
    void testarArrayComNumerosNegativos() {
        int[] numeros = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            numeros[i] = -gerador.nextInt(100);
        }

        for (int i = 0; i < tamanho; i++) {
            assertTrue(numeros[i] < 0);
        }
    }

    @Test
    void testarRedimensionamentoArray() {
        int[] numeros = new int[5];
        numeros = new int[10];
        assertEquals(10, numeros.length);
    }

}
