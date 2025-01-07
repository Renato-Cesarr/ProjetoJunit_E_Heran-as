package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tarefa_dois_meus_arrays.PessoaArray;
import tarefa_dois_model.Bicicleta;
import tarefa_dois_model.Carro;
import tarefa_dois_model.Pessoa;

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
    void testInserirCarro() {
        assertFalse(pessoaArray.inserir(POSICAO_VALIDA, CARRO_1));
    }

    @Test
    void testInserirBicicleta() {
        assertFalse(pessoaArray.inserir(POSICAO_VALIDA, BICICLETA_1));
    }

    @Test
    void testInserirPosicaoInvalida() {
        assertFalse(pessoaArray.inserir(POSICAO_INVALIDA, PESSOA_1));
    }

    @Test
    void testRemoverPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.remover(PESSOA_1));
        assertNull(pessoaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testRemoverCarro() {
        assertFalse(pessoaArray.remover(CARRO_1));
    }

    @Test
    void testRemoverBicicleta() {
        assertFalse(pessoaArray.remover(BICICLETA_1));
    }

    @Test
    void testPesquisarPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.pesquisar(PESSOA_1));
    }

    @Test
    void testPesquisarCarro() {
        assertFalse(pessoaArray.pesquisar(CARRO_1));
    }

    @Test
    void testPesquisarBicicleta() {
        assertFalse(pessoaArray.pesquisar(BICICLETA_1));
    }

    @Test
    void testAtualizarPessoa() {
        pessoaArray.inserir(POSICAO_VALIDA, PESSOA_1);
        assertTrue(pessoaArray.atualizar(POSICAO_VALIDA, PESSOA_2));
        assertEquals(PESSOA_2, pessoaArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void testAtualizarCarro() {
        assertFalse(pessoaArray.atualizar(POSICAO_VALIDA, CARRO_1));
    }

    @Test
    void testAtualizarBicicleta() {
        assertFalse(pessoaArray.atualizar(POSICAO_VALIDA, BICICLETA_1));
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

    @Test
    void testGetSetNome() {
        PESSOA_1.setNome("João");
        assertEquals("João", PESSOA_1.getNome());
        PESSOA_1.setNome("Maria");
        assertEquals("Maria", PESSOA_1.getNome());
    }

    @Test
    void testGetSetIdade() {
        PESSOA_1.setIdade(25);
        assertEquals(25, PESSOA_1.getIdade());
        PESSOA_1.setIdade(30);
        assertEquals(30, PESSOA_1.getIdade());
    }

    @Test
    void testGetSetEndereco() {
        PESSOA_1.setEndereco("Rua A, 123");
        assertEquals("Rua A, 123", PESSOA_1.getEndereco());
        PESSOA_1.setEndereco("Rua B, 456");
        assertEquals("Rua B, 456", PESSOA_1.getEndereco());
    }
}
