package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.PessoaArray;
import tarefa2.model.Pessoa;

class PessoaArrayTest {

    private PessoaArray pessoaArray;
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoaArray = new PessoaArray(5);
        pessoa = new Pessoa(1, "João");
    }

    @Test
    void shouldInsertPessoa() {
        assertTrue(pessoaArray.inserir(0, pessoa));
        assertNotNull(pessoaArray.getItens()[0]);
    }

    @Test
    void shouldNotInsertIncorrectModel() {
        Pessoa fakePessoa = new Pessoa(2, "Carlos");
        assertFalse(pessoaArray.inserir(0, fakePessoa));
        assertNull(pessoaArray.getItens()[0]);
    }

    @Test
    void shouldRemovePessoa() {
        pessoaArray.inserir(0, pessoa);
        assertTrue(pessoaArray.pesquisar(pessoa));

        assertTrue(pessoaArray.remover(pessoa));
        assertNull(pessoaArray.getItens()[0]);
        assertFalse(pessoaArray.pesquisar(pessoa));
    }

    @Test
    void shouldNotRemoveObjectNotInArray() {
        assertFalse(pessoaArray.remover(pessoa));
    }

    @Test
    void shouldReturnTrueWhenModelIsPresent() {
        pessoaArray.inserir(0, pessoa);
        assertTrue(pessoaArray.pesquisar(pessoa));
    }

    @Test
    void shouldReturnFalseWhenModelIsNotPresent() {
        assertFalse(pessoaArray.pesquisar(pessoa));
    }

    @Test
    void shouldUpdatePessoa() {
        pessoaArray.inserir(0, pessoa);
        Pessoa updatedPessoa = new Pessoa(1, "Carlos");
        assertTrue(pessoaArray.atualizar(0, updatedPessoa));
        assertNotEquals(pessoa, pessoaArray.getItens()[0]);
    }

    @Test
    void shouldNotUpdateModelNotInArray() {
        Pessoa fakePessoa = new Pessoa(10, "Ana");
        assertFalse(pessoaArray.atualizar(0, fakePessoa));
    }

    @Test
    void shouldNotUpdateIncorrectModelType() {
        // Não há necessidade de cast, já estamos lidando diretamente com objetos do tipo Pessoa
        assertFalse(pessoaArray.atualizar(0, new Pessoa(2, "Roberta")));
    }

    @Test
    void shouldSortByIdCrescente() {
        pessoaArray.inserir(0, pessoa);
        pessoaArray.inserir(1, new Pessoa(2, "Maria"));
        pessoaArray.inserir(2, new Pessoa(3, "José"));

        pessoaArray.ordenarPorIdCrescente();

        assertEquals(1, pessoaArray.getItens()[0].getId());
        assertEquals(2, pessoaArray.getItens()[1].getId());
        assertEquals(3, pessoaArray.getItens()[2].getId());
    }

    @Test
    void shouldSortByIdDecrescente() {
        pessoaArray.inserir(0, pessoa);
        pessoaArray.inserir(1, new Pessoa(2, "Maria"));
        pessoaArray.inserir(2, new Pessoa(3, "José"));

        pessoaArray.ordenarPorIdDecrescente();

        assertEquals(3, pessoaArray.getItens()[0].getId());
        assertEquals(2, pessoaArray.getItens()[1].getId());
        assertEquals(1, pessoaArray.getItens()[2].getId());
    }
}
