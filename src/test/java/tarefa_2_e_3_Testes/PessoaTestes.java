package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.PessoaArray;
import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Pessoa;

class PessoaArrayTest {

    private PessoaArray pessoaArray;
    private static final Pessoa PESSOA_1 = (Pessoa) EnumArrayMetodosTest.PESSOA_1.getModel();
    private static final Pessoa PESSOA_2 = (Pessoa) EnumArrayMetodosTest.PESSOA_2.getModel();
    private static final Carro CARRO_1 = (Carro) EnumArrayMetodosTest.CARRO_1.getModel();
    private static final Bicicleta BICICLETA_1 = (Bicicleta) EnumArrayMetodosTest.BICICLETA_1.getModel();
    private static final int POSICAO_VALIDA = 0;
    private static final int POSICAO_INVALIDA = 5;

    @BeforeEach
    void setUp() {
        pessoaArray = new PessoaArray(5);
    }

    @Test
    void testInserirPessoa() {
        assertTrue(pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1));
        assertNotNull(pessoaArray.getItens()[POSICAO_VALIDA]);
        assertEquals(PESSOA_1, pessoaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testInserirCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.inserir(POSICAO_VALIDA, CARRO_1);
        });
    }

    @Test
    void testInserirBicicleta_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.inserir(POSICAO_VALIDA, BICICLETA_1);
        });
    }

    @Test
    void testInserirPosicaoInvalida_FalhaArrayIndexOutOfBoundsException() {
        assertFalse(pessoaArray.inserir(POSICAO_INVALIDA, PESSOA_1));
    }

    @Test
    void testRemoverPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.remover(PESSOA_1));
        assertNull(pessoaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testRemoverCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.remover(CARRO_1);
        });
    }

    @Test
    void testRemoverBicicleta_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.remover(BICICLETA_1);
        });
    }

    @Test
    void testPesquisarPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.pesquisar(PESSOA_1));
    }

    @Test
    void testPesquisarCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.pesquisar(CARRO_1);
        });
    }

    @Test
    void testPesquisarBicicleta_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.pesquisar(BICICLETA_1);
        });
    }

    @Test
    void testAtualizarPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.atualizar(POSICAO_VALIDA, PESSOA_2));
        assertEquals(PESSOA_2, pessoaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testAtualizarCarro_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.atualizar(POSICAO_VALIDA, CARRO_1);
        });
    }

    @Test
    void testAtualizarBicicleta_FalhaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaArray.atualizar(POSICAO_VALIDA, BICICLETA_1);
        });
    }

    @Test
    void testOrdenarPorIdCrescente() {
        pessoaArray.inserir(0, PESSOA_2);
        pessoaArray.inserir(1, PESSOA_1);
        pessoaArray.ordenarPorIdCrescente();
        assertEquals(PESSOA_1, pessoaArray.getItens()[0]);
        assertEquals(PESSOA_2, pessoaArray.getItens()[1]);
    }

    @Test
    void testOrdenarPorIdDecrescente() {
        pessoaArray.inserir(0, PESSOA_1);
        pessoaArray.inserir(1, PESSOA_2);
        pessoaArray.ordenarPorIdDecrescente();
        assertEquals(PESSOA_2, pessoaArray.getItens()[0]);
        assertEquals(PESSOA_1, pessoaArray.getItens()[1]);
    }
}
