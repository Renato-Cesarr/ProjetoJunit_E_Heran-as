package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa2.MeusArrays.CarroArray;
import tarefa2.model.Bicicleta;
import tarefa2.model.Carro;
import tarefa2.model.Pessoa;

class CarroArrayTest {

    private CarroArray carroArray;
    private static final Carro CARRO_1 = (Carro) EnumArrayMetodosTest.CARRO_1.getModel();
    private static final Carro CARRO_2 = (Carro) EnumArrayMetodosTest.CARRO_2.getModel();
    private static final Bicicleta BICICLETA_1 = (Bicicleta) EnumArrayMetodosTest.BICICLETA_1.getModel();
    private static final Pessoa PESSOA_1 = (Pessoa) EnumArrayMetodosTest.PESSOA_1.getModel();
    private static final int POSICAO_VALIDA = 0;
    private static final int POSICAO_INVALIDA = 5;

    @BeforeEach
    void setUp() {
        carroArray = new CarroArray(5);
    }

    @Test
    void falhaInserirCarroIllegalArgumentException() {
        assertTrue(carroArray.inserir(POSICAO_VALIDA, CARRO_1));
        assertNotNull(carroArray.getItens()[POSICAO_VALIDA]);
        assertEquals(CARRO_1, carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void falhaInserirBicicletaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.inserir(POSICAO_VALIDA, BICICLETA_1);
        });
    }

    @Test
    void falhaInserirPessoaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.inserir(POSICAO_VALIDA, PESSOA_1);
        });
    }

    @Test
    void falhaInserirPosicaoInvalidaFalse() {
        assertFalse(carroArray.inserir(POSICAO_INVALIDA, CARRO_1));
    }

    @Test
    void falhaRemoverCarroIllegalArgumentException() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.remover(CARRO_1));
        assertNull(carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void falhaRemoverBicicletaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.remover(BICICLETA_1);
        });
    }

    @Test
    void falhaRemoverPessoaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.remover(PESSOA_1);
        });
    }

    @Test
    void falhaPesquisarCarroIllegalArgumentException() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.pesquisar(CARRO_1));
    }

    @Test
    void falhaPesquisarBicicletaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.pesquisar(BICICLETA_1);
        });
    }

    @Test
    void falhaPesquisarPessoaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.pesquisar(PESSOA_1);
        });
    }

    @Test
    void falhaAtualizarCarroIllegalArgumentException() {
        carroArray.inserir(POSICAO_VALIDA, CARRO_1);
        assertTrue(carroArray.atualizar(POSICAO_VALIDA, CARRO_2));
        assertEquals(CARRO_2, carroArray.getItens()[POSICAO_VALIDA]);
    }

    @Test
    void falhaAtualizarBicicletaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.atualizar(POSICAO_VALIDA, BICICLETA_1);
        });
    }

    @Test
    void falhaAtualizarPessoaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            carroArray.atualizar(POSICAO_VALIDA, PESSOA_1);
        });
    }

    @Test
    void falhaOrdenarPorIdCrescente() {
        carroArray.inserir(0, CARRO_2);
        carroArray.inserir(1, CARRO_1);
        carroArray.ordenarPorIdCrescente();
        assertEquals(CARRO_1, carroArray.getItens()[0]);
        assertEquals(CARRO_2, carroArray.getItens()[1]);
    }

    @Test
    void falhaOrdenarPorIdDecrescente() {
        carroArray.inserir(0, CARRO_1);
        carroArray.inserir(1, CARRO_2);
        carroArray.ordenarPorIdDecrescente();
        assertEquals(CARRO_2, carroArray.getItens()[0]);
        assertEquals(CARRO_1, carroArray.getItens()[1]);
    }
}
