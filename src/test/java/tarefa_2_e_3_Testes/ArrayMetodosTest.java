package tarefa_2_e_3_Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tarefa3.ArrayMetodos;
import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Pessoa;
import tarefa2.model.Model;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMetodosTest {

	private ArrayMetodos arrayMetodos;
	private static final Logger logger = Logger.getLogger(ArrayMetodosTest.class.getName());

	private static final Pessoa PESSOA_1 = new Pessoa(1, "Pessoa 1");
	private static final Bicicleta BICICLETA_1 = new Bicicleta(2, "Bicicleta 1");
	private static final Carro CARRO_1 = new Carro(3, "Carro 1");
	private static final Model PESSOA_INVALIDA = new Pessoa(4, "Pessoa Invalida");
	private static final int POSICAO_VALIDA = 0;
	private static final int POSICAO_INVALIDA = 5;

	@BeforeEach
	void setUp() {
		arrayMetodos = new ArrayMetodos(5);
	}

	@Test
	void testInserir() {
		assertTrue(arrayMetodos.inserir(POSICAO_VALIDA, PESSOA_1));
		assertFalse(arrayMetodos.inserir(POSICAO_INVALIDA, PESSOA_1));
		assertFalse(arrayMetodos.inserir(POSICAO_VALIDA, null));
	}

	@Test
	void testOrdenarPorIdCrescente() {
		arrayMetodos.inserir(0, PESSOA_1);
		arrayMetodos.inserir(1, BICICLETA_1);
		arrayMetodos.inserir(2, CARRO_1);

		assertEquals(PESSOA_1, arrayMetodos.getItens()[0]);
		assertEquals(BICICLETA_1, arrayMetodos.getItens()[1]);
		assertEquals(CARRO_1, arrayMetodos.getItens()[2]);
	}

	@Test
	void testRemover() {
		arrayMetodos.inserir(0, PESSOA_1);
		arrayMetodos.inserir(1, BICICLETA_1);
		assertTrue(arrayMetodos.remover(PESSOA_1));
		assertFalse(arrayMetodos.remover(PESSOA_INVALIDA));
	}

	@Test
	void testPesquisar() {
		arrayMetodos.inserir(0, PESSOA_1);
		arrayMetodos.inserir(1, BICICLETA_1);

		assertTrue(arrayMetodos.pesquisar(PESSOA_1));
		assertFalse(arrayMetodos.pesquisar(PESSOA_INVALIDA));
	}

	@Test
	void testAtualizar() {
		arrayMetodos.inserir(0, PESSOA_1);
		assertTrue(arrayMetodos.atualizar(0, BICICLETA_1));
		assertFalse(arrayMetodos.atualizar(POSICAO_INVALIDA, PESSOA_1));
		assertFalse(arrayMetodos.atualizar(0, null));
	}

	@Test
	void testOrdenarPorIdDecrescente() {
		arrayMetodos.inserir(0, PESSOA_1);
		arrayMetodos.inserir(1, BICICLETA_1);
		arrayMetodos.inserir(2, CARRO_1);

		assertEquals(BICICLETA_1, arrayMetodos.getItens()[1]);
	}

	@Test
	void testInserirValoresInvalidos() {
		arrayMetodos.inserir(POSICAO_VALIDA, null);

		arrayMetodos.inserir(POSICAO_INVALIDA, PESSOA_1);

	}

	@Test
	void testAtualizarPosicaoInvalida() {
		arrayMetodos.atualizar(POSICAO_INVALIDA, PESSOA_1);

	}
}
