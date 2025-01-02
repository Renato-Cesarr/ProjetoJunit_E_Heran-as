package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.CarroArray;
import tarefa2.model.Carro;

class CarroArrayTest {

    private CarroArray carroArray;
    private Carro carroAtualizado;
    private Carro carroFalso;
    private Carro carroAzul;
    private Carro carroPreto;
    private Carro carroVerde;

    @BeforeEach
    void configurar() {
        carroArray = new CarroArray(5);
        carroAzul = new Carro(1, "ABC-1234");
        carroAtualizado = new Carro(1, "XYZ-5678");
        carroFalso = new Carro(10, "DEF-1234");
        carroVerde = new Carro(3, "Verde");
        carroPreto = new Carro(2, "Preto");
    }

    @Test
    void deveInserirCarro() {
        assertTrue(carroArray.inserir(0, carroAzul));
        assertNotNull(carroArray.getItens()[0]);
    }

    @Test
    void deveRemoverCarro() {
        carroArray.inserir(0, carroAzul);
        assertTrue(carroArray.pesquisar(carroAzul));
        assertTrue(carroArray.remover(carroAzul));
        assertNull(carroArray.getItens()[0]);
        assertFalse(carroArray.pesquisar(carroAzul));
    }

    @Test
    void naoDeveRemoverObjetoNaoEncontrado() {
        assertFalse(carroArray.remover(carroAzul));
    }

    @Test
    void deveRetornarVerdadeiroQuandoModeloEstiverPresente() {
        carroArray.inserir(0, carroAzul);
        assertTrue(carroArray.pesquisar(carroAzul));
    }

    @Test
    void deveRetornarFalsoQuandoModeloNaoEstiverPresente() {
        assertFalse(carroArray.pesquisar(carroAzul));
    }

    @Test
    void deveAtualizarCarro() {
        carroArray.inserir(0, carroAzul);
        assertTrue(carroArray.atualizar(0, carroAtualizado));
        assertEquals(carroAtualizado, carroArray.getItens()[0]);
    }

    @Test
    void naoDeveAtualizarModeloNaoEncontrado() {
        assertFalse(carroArray.atualizar(0, carroFalso));
    }

    @Test
    void naoDeveAtualizarTipoDeModeloIncorreto() {
        Carro carroTipoIncorreto = new Carro(2, "JKL-1234");
        assertFalse(carroArray.atualizar(0, carroTipoIncorreto));
    }

    @Test
    void deveOrdenarPorIdCrescente() {
        carroArray.inserir(0, carroVerde);
        carroArray.inserir(1, carroAzul);
        carroArray.inserir(2, carroPreto);

        carroArray.ordenarPorIdCrescente();

        assertEquals(1, carroArray.getItens()[0].getId());
        assertEquals(2, carroArray.getItens()[1].getId());
        assertEquals(3, carroArray.getItens()[2].getId());
    }

    @Test
    void deveOrdenarPorIdDecrescente() {
        carroArray.inserir(0, carroAzul);
        carroArray.inserir(1, carroPreto);
        carroArray.inserir(2, carroVerde);

        carroArray.ordenarPorIdDecrescente();

        assertEquals(3, carroArray.getItens()[0].getId());
        assertEquals(2, carroArray.getItens()[1].getId());
        assertEquals(1, carroArray.getItens()[2].getId());
    }
}
