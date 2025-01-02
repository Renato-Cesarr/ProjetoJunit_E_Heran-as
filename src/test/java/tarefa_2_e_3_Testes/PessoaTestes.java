package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tarefa2.MeusArrays.PessoaArray;
import tarefa2.model.Pessoa;

class PessoaArrayTest {

    private static final Logger logger = LoggerFactory.getLogger(PessoaArrayTest.class);
    private PessoaArray pessoaArray;
    private Pessoa pessoa;
    private Pessoa pessoaAtualizada;
    private Pessoa pessoaFalsa;
    private Pessoa pessoaMaria;
    private Pessoa pessoaJose;

    @BeforeEach
    void configurar() {
        pessoaArray = new PessoaArray(5);
        pessoa = new Pessoa(1, "João");
        pessoaAtualizada = new Pessoa(1, "Carlos");
        pessoaFalsa = new Pessoa(10, "Ana");
        pessoaMaria = new Pessoa(2, "Maria");
        pessoaJose = new Pessoa(3, "José");
    }

    @Test
    void deveInserirPessoa() {
            assertTrue(pessoaArray.inserir(0, pessoa));
            assertNotNull(pessoaArray.getItens()[0]);
    }

    @Test
    void deveRemoverPessoa() {
            pessoaArray.inserir(0, pessoa);
            assertTrue(pessoaArray.pesquisar(pessoa));
            assertTrue(pessoaArray.remover(pessoa));
            assertNull(pessoaArray.getItens()[0]);
            assertFalse(pessoaArray.pesquisar(pessoa));
    }

    @Test
    void naoDeveRemoverObjetoNaoEncontrado() {
            assertFalse(pessoaArray.remover(pessoa));

    }

    @Test
    void deveRetornarVerdadeiroQuandoModeloEstiverPresente() {
            pessoaArray.inserir(0, pessoa);
            assertTrue(pessoaArray.pesquisar(pessoa));

    }

    @Test
    void deveRetornarFalsoQuandoModeloNaoEstiverPresente() {
            assertFalse(pessoaArray.pesquisar(pessoa));
    }

    @Test
    void deveAtualizarPessoa() {
            pessoaArray.inserir(0, pessoa);
            assertTrue(pessoaArray.atualizar(0, pessoaAtualizada));
            assertNotEquals(pessoa, pessoaArray.getItens()[0]);
    }

    @Test
    void naoDeveAtualizarModeloNaoEncontrado() {
            assertFalse(pessoaArray.atualizar(0, pessoaFalsa));

    }

    @Test
    void naoDeveAtualizarTipoDeModeloIncorreto() {
            assertFalse(pessoaArray.atualizar(0, new Pessoa(2, "Roberta")));
    }

    @Test
    void deveOrdenarPorIdCrescente() {
            pessoaArray.inserir(0, pessoa);
            pessoaArray.inserir(1, pessoaMaria);
            pessoaArray.inserir(2, pessoaJose);

            pessoaArray.ordenarPorIdCrescente();

            assertEquals(1, pessoaArray.getItens()[0].getId());
            assertEquals(2, pessoaArray.getItens()[1].getId());
            assertEquals(3, pessoaArray.getItens()[2].getId());

    }

    @Test
    void deveOrdenarPorIdDecrescente() {
            pessoaArray.inserir(0, pessoa);
            pessoaArray.inserir(1, pessoaMaria);
            pessoaArray.inserir(2, pessoaJose);

            pessoaArray.ordenarPorIdDecrescente();

            assertEquals(3, pessoaArray.getItens()[0].getId());
            assertEquals(2, pessoaArray.getItens()[1].getId());
            assertEquals(1, pessoaArray.getItens()[2].getId());

    }
    @Test
    void testOrdenarPorIdCrescenteComNulos() {
        Pessoa pessoa1 = new Pessoa(2, "Pessoa 2");
        Pessoa pessoa2 = new Pessoa(1, "Pessoa 1");

        PessoaArray pessoaArray = new PessoaArray(3);
        pessoaArray.inserir(0, pessoa1);
        pessoaArray.inserir(1, null);
        pessoaArray.inserir(2, pessoa2);

        pessoaArray.ordenarPorIdCrescente();

        Pessoa[] itens = pessoaArray.getItens();
        assertEquals(pessoa2, itens[0]);
    }
    
    @Test
    void testOrdenarPorIdCrescente() {
        Pessoa pessoa1 = new Pessoa(3, "Pessoa 3");
        Pessoa pessoa2 = new Pessoa(1, "Pessoa 1");
        Pessoa pessoa3 = new Pessoa(2, "Pessoa 2");

        PessoaArray pessoaArray = new PessoaArray(3);
        pessoaArray.inserir(0, pessoa1);
        pessoaArray.inserir(1, pessoa2);
        pessoaArray.inserir(2, pessoa3);

        pessoaArray.ordenarPorIdCrescente();

        Pessoa[] itens = pessoaArray.getItens();
        assertEquals(pessoa2, itens[0]);
        assertEquals(pessoa3, itens[1]);
        assertEquals(pessoa1, itens[2]);
    }


}
