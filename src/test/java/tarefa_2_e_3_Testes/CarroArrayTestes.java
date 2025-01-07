package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa_dois_meus_arrays.CarroArray;
import tarefa_dois_model.Carro;
import tarefa_dois_model.Pessoa;

class CarroArrayTest {

    private CarroArray carroArray;
    private static final Carro CARRO_1 = (Carro) EnumArrayMetodosTest.CARRO_1.getModel();
    private static final Carro CARRO_2 = (Carro) EnumArrayMetodosTest.CARRO_2.getModel();
    private static final Pessoa PESSOA_1 = (Pessoa) EnumArrayMetodosTest.PESSOA_1.getModel();
    private static final int POSICAO_VALIDA = 0;
    private static final int POSICAO_INVALIDA = 5;

    @BeforeEach
    void setUp() {
        carroArray = new CarroArray(5);
    }

    @Test
    void testInserirCarro() {
        assertTrue(carroArray.inserir(POSICAO_VALIDA, CARRO_1));
        assertNotNull(carroArray.getItens()[POSICAO_VALIDA]);
        assertEquals(CARRO_1, carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testInserirPosicaoInvalida_FalhaArrayIndexOutOfBoundsException() {
        assertFalse(carroArray.inserir(POSICAO_INVALIDA, CARRO_1));
    }

    @Test
    void testRemoverCarro() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.remover(CARRO_1));
        assertNull(carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testPesquisarCarro() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.pesquisar(CARRO_1));
    }

    @Test
    void testAtualizarCarro() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.atualizar(POSICAO_VALIDA, CARRO_2));
        assertEquals(CARRO_2, carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testOrdenarPorIdCrescente() {
        carroArray.inserir(0, CARRO_2);
        carroArray.inserir(1, CARRO_1);
        carroArray.ordenarPorIdCrescente();
        assertEquals(CARRO_1, carroArray.getItens()[0]);
        assertEquals(CARRO_2, carroArray.getItens()[1]);
    }

    @Test
    void testOrdenarPorIdDecrescente() {
        carroArray.inserir(0, CARRO_1);
        carroArray.inserir(1, CARRO_2);
        carroArray.ordenarPorIdDecrescente();
        assertEquals(CARRO_2, carroArray.getItens()[0]);
        assertEquals(CARRO_1, carroArray.getItens()[1]);
    }

    @Test
    void testGetSetPlaca() {
        Carro carro = new Carro(1, "Carro de Teste", 30000.0, "AAA1234", "Sedan", 2015);
        assertEquals("AAA1234", carro.getPlaca());
        carro.setPlaca("BBB5678");
        assertEquals("BBB5678", carro.getPlaca());
    }

    @Test
    void testGetSetModelo() {
        Carro carro = new Carro(1, "Carro de Teste", 30000.0, "AAA1234", "Sedan", 2015);
        assertEquals("Sedan", carro.getModelo());
        carro.setModelo("SUV");
        assertEquals("SUV", carro.getModelo());
    }

    @Test
    void testGetSetAno() {
        Carro carro = new Carro(1, "Carro de Teste", 30000.0, "AAA1234", "Sedan", 2015);
        assertEquals(2015, carro.getAno());
        carro.setAno(2020);
        assertEquals(2020, carro.getAno());
    }

    @Test
    void testHerancaArrayMetodos() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.pesquisar(CARRO_1));
    }

    @Test
    void testInserirModeloInvalido() {
        assertThrows(RuntimeException.class, () -> {
            carroArray.inserir(POSICAO_VALIDA, PESSOA_1);
        });
    }

    @Test
    void testRemoverModeloInvalido() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertThrows(RuntimeException.class, () -> {
            carroArray.remover(PESSOA_1);
        });
    }

    @Test
    void testPesquisarModeloInvalido() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertThrows(RuntimeException.class, () -> {
            carroArray.pesquisar(PESSOA_1);
        });
    }

    @Test
    void testAtualizarModeloInvalido() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertThrows(RuntimeException.class, () -> {
            carroArray.atualizar(POSICAO_VALIDA, PESSOA_1);
        });
    }
}
