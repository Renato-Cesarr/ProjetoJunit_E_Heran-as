package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tarefa2.MeusArrays.BicicletaArray;
import tarefa2.model.Bicicleta;

class BicicletaArrayTest {

    private static final Logger logger = LoggerFactory.getLogger(BicicletaArrayTest.class);
    private BicicletaArray bicicletaArray;
    private Bicicleta bicicletaAtualizada;
    private Bicicleta bicicletaFalsa;
    private Bicicleta bicicletaVerde;
    private Bicicleta bicicletaPreta;
    private Bicicleta bicicletaAzul;

    @BeforeEach
    void configurar() {
        bicicletaArray = new BicicletaArray(5);
        bicicletaAzul = new Bicicleta(1, "Azul");
        bicicletaAtualizada = new Bicicleta(1, "Vermelha");
        bicicletaFalsa = new Bicicleta(10, "Amarela");
        bicicletaVerde = new Bicicleta(3, "Verde");
        bicicletaPreta = new Bicicleta(2, "Preta");
    }

    @Test
    void deveInserirBicicleta() {
            assertTrue(bicicletaArray.inserir(0, bicicletaAzul));
            assertNotNull(bicicletaArray.getItens()[0]);
    }

    @Test
    void deveRemoverBicicleta() {
            bicicletaArray.inserir(0, bicicletaAzul);
            assertTrue(bicicletaArray.pesquisar(bicicletaAzul));
            assertTrue(bicicletaArray.remover(bicicletaAzul));
            assertNull(bicicletaArray.getItens()[0]);
            assertFalse(bicicletaArray.pesquisar(bicicletaAzul));
    }

    @Test
    void naoDeveRemoverObjetoNaoEncontrado() {
            assertFalse(bicicletaArray.remover(bicicletaAzul));
    }

    @Test
    void deveRetornarVerdadeiroQuandoModeloEstiverPresente() {
            bicicletaArray.inserir(0, bicicletaAzul);
            assertTrue(bicicletaArray.pesquisar(bicicletaAzul));
    }

    @Test
    void deveRetornarFalsoQuandoModeloNaoEstiverPresente() {
            assertFalse(bicicletaArray.pesquisar(bicicletaAzul));
    }

    @Test
    void deveAtualizarBicicleta() {
            bicicletaArray.inserir(0, bicicletaAzul);
            assertTrue(bicicletaArray.atualizar(0, bicicletaAtualizada));
            assertNotEquals(bicicletaAzul, bicicletaArray.getItens()[0]);
    }

    @Test
    void naoDeveAtualizarModeloNaoEncontrado() {
            assertFalse(bicicletaArray.atualizar(0, bicicletaFalsa));
    }

    @Test
    void naoDeveAtualizarTipoDeModeloIncorreto() {
            Bicicleta bicicletaPretaAtualizada = new Bicicleta(2, "Preta");
            assertFalse(bicicletaArray.atualizar(0, bicicletaPretaAtualizada));

    }

    @Test
    void deveOrdenarPorIdCrescente() {
            bicicletaArray.inserir(0, bicicletaVerde);
            bicicletaArray.inserir(1, bicicletaPreta);
            bicicletaArray.inserir(2, bicicletaAzul);

            bicicletaArray.ordenarPorIdCrescente();

            assertEquals(1, bicicletaArray.getItens()[0].getId());
            assertEquals(2, bicicletaArray.getItens()[1].getId());
            assertEquals(3, bicicletaArray.getItens()[2].getId());
    }

    @Test
    void deveOrdenarPorIdDecrescente() {
            bicicletaArray.inserir(0, bicicletaAzul);
            bicicletaArray.inserir(1, bicicletaPreta);
            bicicletaArray.inserir(2, bicicletaVerde);

            bicicletaArray.ordenarPorIdDecrescente();

            assertEquals(3, bicicletaArray.getItens()[0].getId());
            assertEquals(2, bicicletaArray.getItens()[1].getId());
            assertEquals(1, bicicletaArray.getItens()[2].getId());
    }
}
