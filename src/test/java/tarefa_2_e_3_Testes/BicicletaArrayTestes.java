package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.BicicletaArray;
import tarefa2.model.Bicicleta;

class BicicletaArrayTest {

	private BicicletaArray bicicletaArray;
	private Bicicleta bicicleta;

	@BeforeEach
	void setUp() {
		bicicletaArray = new BicicletaArray(5);
		bicicleta = new Bicicleta(1, "Azul");
	}

	@Test
	void shouldInsertBicicleta() {
		assertTrue(bicicletaArray.inserir(0, bicicleta));
		assertNotNull(bicicletaArray.getItens()[0]);
	}

	@Test
	void shouldRemoveBicicleta() {
		bicicletaArray.inserir(0, bicicleta);
		assertTrue(bicicletaArray.pesquisar(bicicleta));
		assertTrue(bicicletaArray.remover(bicicleta));
		assertNull(bicicletaArray.getItens()[0]);
		assertFalse(bicicletaArray.pesquisar(bicicleta));
	}

	@Test
	void shouldNotRemoveObjectNotInArray() {
		assertFalse(bicicletaArray.remover(bicicleta));
	}

	@Test
	void shouldReturnTrueWhenModelIsPresent() {
		bicicletaArray.inserir(0, bicicleta);
		assertTrue(bicicletaArray.pesquisar(bicicleta));
	}

	@Test
	void shouldReturnFalseWhenModelIsNotPresent() {
		assertFalse(bicicletaArray.pesquisar(bicicleta));
	}

	@Test
	void shouldUpdateBicicleta() {
		bicicletaArray.inserir(0, bicicleta);
		Bicicleta updatedBicicleta = new Bicicleta(1, "Vermelha");
		assertTrue(bicicletaArray.atualizar(0, updatedBicicleta));
		assertNotEquals(bicicleta, bicicletaArray.getItens()[0]);
	}

	@Test
	void shouldNotUpdateModelNotInArray() {
		Bicicleta fakeBicicleta = new Bicicleta(10, "Amarela");
		assertFalse(bicicletaArray.atualizar(0, fakeBicicleta));
	}

	@Test
	void shouldNotUpdateIncorrectModelType() {
		assertFalse(bicicletaArray.atualizar(0, new Bicicleta(2, "Preta")));
	}

	@Test
	void shouldSortByIdCrescente() {
		bicicletaArray.inserir(0, new Bicicleta(3, "Verde"));
		bicicletaArray.inserir(1, new Bicicleta(2, "Preta"));
		bicicletaArray.inserir(2, new Bicicleta(1, "Azul"));

		bicicletaArray.ordenarPorIdCrescente();

		assertEquals(1, bicicletaArray.getItens()[0].getId());
		assertEquals(2, bicicletaArray.getItens()[1].getId());
		assertEquals(3, bicicletaArray.getItens()[2].getId());
	}

	@Test
	void shouldSortByIdDecrescente() {
		bicicletaArray.inserir(0, new Bicicleta(1, "Azul"));
		bicicletaArray.inserir(1, new Bicicleta(2, "Preta"));
		bicicletaArray.inserir(2, new Bicicleta(3, "Verde"));

		bicicletaArray.ordenarPorIdDecrescente();

		assertEquals(3, bicicletaArray.getItens()[0].getId());
		assertEquals(2, bicicletaArray.getItens()[1].getId());
		assertEquals(1, bicicletaArray.getItens()[2].getId());
	}
}
