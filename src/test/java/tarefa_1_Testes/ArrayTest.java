package tarefa_1_Testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;

class ArrayTest {

	private Random gerador;
	private int tamanho;

	@BeforeEach
	void configurar() {
		gerador = new Random();
		tamanho = 10;
	}

	@Test
	void testarArrayUnidimensionalComNumeros() {
		int[] numeros = new int[tamanho];

		for (int i = 0; i < tamanho; i++) {
			numeros[i] = gerador.nextInt(100);
		}

		assertEquals(tamanho, numeros.length);

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

		letras[3] = 'Z';
		assertEquals('Z', letras[3]);
	}

	@Test
	void testarArrayBidimensional() {
		int linhas = 5;
		int colunas = 6;
		int[][] matriz = new int[linhas][colunas];
		Random gerador = new Random();

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = gerador.nextInt(100);
			}
		}

		assertEquals(linhas, matriz.length);

		int valorEsperado = 999;
		int linhaAlvo = 2;
		int colunaAlvo = 3;
		matriz[linhaAlvo][colunaAlvo] = valorEsperado;

		assertEquals(valorEsperado, matriz[linhaAlvo][colunaAlvo], "Elemento esperado não corresponde.");
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
}
