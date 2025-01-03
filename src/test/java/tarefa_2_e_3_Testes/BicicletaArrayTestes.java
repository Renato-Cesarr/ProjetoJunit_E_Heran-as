package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.BicicletaArray;
import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Pessoa;

class BicicletaArrayTest {

    private BicicletaArray bicicletaArray;
    private static final Bicicleta BICICLETA_1 = (Bicicleta) EnumArrayMetodosTest.BICICLETA_1.getModel();
    private static final Bicicleta BICICLETA_2 = (Bicicleta) EnumArrayMetodosTest.BICICLETA_2.getModel();
    private static final Carro CARRO_1 = (Carro) EnumArrayMetodosTest.CARRO_1.getModel();
    private static final Pessoa PESSOA_1 = (Pessoa) EnumArrayMetodosTest.PESSOA_1.getModel();
    private static final int POSICAO_VALIDA = 0;
    private static final int POSICAO_INVALIDA = 5;

    @BeforeEach
    void setUp() {
        bicicletaArray = new BicicletaArray(5);
    }

    @Test
    void testInserirBicicleta() {
        assertTrue(bicicletaArray.inserir(POSICAO_VALIDA, BICICLETA_1));
        assertNotNull(bicicletaArray.getItens()[POSICAO_VALIDA]);
        assertEquals(BICICLETA_1, bicicletaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testInserirCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.inserir(POSICAO_VALIDA, CARRO_1);
        });
    }

    @Test
    void testInserirPessoa_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        });
    }

    @Test
    void testInserirPosicaoInvalida_FalhaArrayIndexOutOfBoundsException() {
        assertFalse(bicicletaArray.inserir(POSICAO_INVALIDA, BICICLETA_1));
    }

    @Test
    void testRemoverBicicleta() {
        bicicletaArray.inserir(POSICAO_VALIDA, BICICLETA_1);
        assertTrue(bicicletaArray.remover(BICICLETA_1));
        assertNull(bicicletaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testRemoverCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.remover(CARRO_1);
        });
    }

    @Test
    void testRemoverPessoa_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.remover(PESSOA_1);
        });
    }

    @Test
    void testPesquisarBicicleta() {
        bicicletaArray.inserir(POSICAO_VALIDA, BICICLETA_1);
        assertTrue(bicicletaArray.pesquisar(BICICLETA_1));
    }

    @Test
    void testPesquisarCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.pesquisar(CARRO_1);
        });
    }

    @Test
    void testPesquisarPessoa_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.pesquisar(PESSOA_1);
        });
    }

    @Test
    void testAtualizarBicicleta() {
        bicicletaArray.inserir(POSICAO_VALIDA, BICICLETA_1);
        assertTrue(bicicletaArray.atualizar(POSICAO_VALIDA, BICICLETA_2));
        assertEquals(BICICLETA_2, bicicletaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testAtualizarCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.atualizar(POSICAO_VALIDA, CARRO_1);
        });
    }

    @Test
    void testAtualizarPessoa_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaArray.atualizar(POSICAO_VALIDA, PESSOA_1);
        });
    }

    @Test
    void testOrdenarPorIdCrescente() {
        bicicletaArray.inserir(0, BICICLETA_2);
        bicicletaArray.inserir(1, BICICLETA_1);
        bicicletaArray.ordenarPorIdCrescente();
        assertEquals(BICICLETA_1, bicicletaArray.getItens()[0]);
        assertEquals(BICICLETA_2, bicicletaArray.getItens()[1]);
    }

    @Test
    void testOrdenarPorIdDecrescente() {
        bicicletaArray.inserir(0, BICICLETA_1);
        bicicletaArray.inserir(1, BICICLETA_2);
        bicicletaArray.ordenarPorIdDecrescente();
        assertEquals(BICICLETA_2, bicicletaArray.getItens()[0]);
        assertEquals(BICICLETA_1, bicicletaArray.getItens()[1]);
    }
}
