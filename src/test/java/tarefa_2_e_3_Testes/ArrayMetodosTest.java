package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.model.Model;
import tarefa3.ArrayMetodos;

class ArrayMetodosTest {

    private ArrayMetodos arrayMetodos;
    private static final Model PESSOA_1 = EnumArrayMetodosTest.PESSOA_1.getModel();
    private static final Model BICICLETA_1 = EnumArrayMetodosTest.BICICLETA_1.getModel();
    private static final Model CARRO_1 = EnumArrayMetodosTest.CARRO_1.getModel();
    private static final Model PESSOA_INVALIDA = EnumArrayMetodosTest.PESSOA_INVALIDA.getModel();
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
    void testOrdenarPorIdCrescente() {
        arrayMetodos.inserir(0, CARRO_1);
        arrayMetodos.inserir(1, PESSOA_1);
        arrayMetodos.inserir(2, BICICLETA_1);
        arrayMetodos.ordenarPorIdCrescente();
        assertEquals(PESSOA_1, arrayMetodos.getItens()[0]);
        assertEquals(BICICLETA_1, arrayMetodos.getItens()[1]);
        assertEquals(CARRO_1, arrayMetodos.getItens()[2]);
    }

    @Test
    void testOrdenarPorIdDecrescente() {
        arrayMetodos.inserir(0, PESSOA_1);
        arrayMetodos.inserir(1, BICICLETA_1);
        arrayMetodos.inserir(2, CARRO_1);
        arrayMetodos.ordenarPorIdDecrescente();
        assertEquals(CARRO_1, arrayMetodos.getItens()[0]);
        assertEquals(BICICLETA_1, arrayMetodos.getItens()[1]);
        assertEquals(PESSOA_1, arrayMetodos.getItens()[2]);
    }
}
