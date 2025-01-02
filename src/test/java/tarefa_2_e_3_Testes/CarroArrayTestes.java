package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.CarroArray;
import tarefa2.model.Carro;

class CarroArrayTest {

    private CarroArray carroArray;
    private Carro carro;

    @BeforeEach
    void setUp() {
        carroArray = new CarroArray(5);
        carro = new Carro(1, "ABC-1234");
    }

    @Test
    void shouldInsertCarro() {
        assertTrue(carroArray.inserir(0, carro));
        assertNotNull(carroArray.getItens()[0]);
    }

    @Test
    void shouldNotInsertIncorrectModel() {
        Carro fakeCarro = new Carro(2, "XYZ-7890");
        assertFalse(carroArray.inserir(0, fakeCarro));
        assertNull(carroArray.getItens()[0]);
    }

    @Test
    void shouldRemoveCarro() {
        carroArray.inserir(0, carro);
        assertTrue(carroArray.pesquisar(carro));

        assertTrue(carroArray.remover(carro));
        assertNull(carroArray.getItens()[0]);
        assertFalse(carroArray.pesquisar(carro));
    }

    @Test
    void shouldNotRemoveObjectNotInArray() {
        assertFalse(carroArray.remover(carro));
    }

    @Test
    void shouldReturnTrueWhenModelIsPresent() {
        carroArray.inserir(0, carro);
        assertTrue(carroArray.pesquisar(carro));
    }

    @Test
    void shouldReturnFalseWhenModelIsNotPresent() {
        assertFalse(carroArray.pesquisar(carro));
    }

    @Test
    void shouldUpdateCarro() {
        carroArray.inserir(0, carro);
        Carro updatedCarro = new Carro(1, "XYZ-5678");
        assertTrue(carroArray.atualizar(0, updatedCarro));
        assertNotEquals(carro, carroArray.getItens()[0]);
    }

    @Test
    void shouldNotUpdateModelNotInArray() {
        Carro fakeCarro = new Carro(10, "DEF-1234");
        assertFalse(carroArray.atualizar(0, fakeCarro));
    }

    @Test
    void shouldNotUpdateIncorrectModelType() {
        assertFalse(carroArray.atualizar(0, new Carro(2, "JKL-1234")));
    }

    @Test
    void shouldSortByIdCrescente() {
        carroArray.inserir(0, new Carro(3, "Verde"));
        carroArray.inserir(1, new Carro(1, "Azul"));
        carroArray.inserir(2, new Carro(2, "Preto"));

        carroArray.ordenarPorIdCrescente();

        assertEquals(1, carroArray.getItens()[0].getId());
        assertEquals(2, carroArray.getItens()[1].getId());
        assertEquals(3, carroArray.getItens()[2].getId());
    }

    @Test
    void shouldSortByIdDecrescente() {
        carroArray.inserir(0, new Carro(1, "Azul"));
        carroArray.inserir(1, new Carro(2, "Preto"));
        carroArray.inserir(2, new Carro(3, "Verde"));

        carroArray.ordenarPorIdDecrescente();

        assertEquals(3, carroArray.getItens()[0].getId());
        assertEquals(2, carroArray.getItens()[1].getId());
        assertEquals(1, carroArray.getItens()[2].getId());
    }
}
