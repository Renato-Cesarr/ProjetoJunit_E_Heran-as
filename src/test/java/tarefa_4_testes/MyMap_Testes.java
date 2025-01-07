package tarefa_4_testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa_quadro.MyMap;

class MyMapTest {

    private MyMap<String, Integer> myMap;

    private static final String CHAVE_1 = "chave1";
    private static final String CHAVE_2 = "chave2";
    private static final String CHAVE_3 = "chave3";
    private static final String CHAVE_4 = "chave4";
    private static final String CHAVE_INEXISTENTE = "chave5";
    private static final int VALOR_1 = 10;
    private static final int VALOR_2 = 20;
    private static final int VALOR_3 = 30;
    private static final int VALOR_4 = 40;

    @BeforeEach
    void setUp() {
        myMap = new MyMap<>();
        myMap.put(CHAVE_1, VALOR_1);
        myMap.put(CHAVE_2, VALOR_2);
        myMap.put(CHAVE_3, VALOR_3);
    }

    @Test
    void deveriaAdicionarNovoElementoQuandoChaveNaoExistir() {
        boolean resultado = myMap.put(CHAVE_4, VALOR_4);
        assertTrue(resultado);
        assertEquals(VALOR_4, myMap.get(CHAVE_4));
        assertEquals(4, myMap.size());
    }

    @Test
    void naoDeveriaAdicionarElementoComChaveExistente() {
        boolean resultado = myMap.put(CHAVE_1, 100);
        assertFalse(resultado);
        assertEquals(VALOR_1, myMap.get(CHAVE_1));
        assertEquals(3, myMap.size());
    }

    @Test
    void deveriaRemoverElementoQuandoChaveExistir() {
        boolean resultado = myMap.remove(CHAVE_2);
        assertTrue(resultado);
        assertNull(myMap.get(CHAVE_2));
        assertEquals(2, myMap.size());
    }

    @Test
    void naoDeveriaRemoverElementoQuandoChaveNaoExistir() {
        boolean resultado = myMap.remove(CHAVE_INEXISTENTE);
        assertFalse(resultado);
        assertEquals(3, myMap.size());
    }

    @Test
    void deveriaRetornarValorCorretoParaChaveExistente() {
        Integer valor = myMap.get(CHAVE_3);
        assertNotNull(valor);
        assertEquals(VALOR_3, valor);
    }

    @Test
    void deveriaRetornarNullParaChaveNaoExistente() {
        Integer valor = myMap.get(CHAVE_INEXISTENTE);
        assertNull(valor);
    }

    @Test
    void deveriaConfirmarExistenciaDeChaveQuandoElaEstiverPresente() {
        assertTrue(myMap.containsKey(CHAVE_1));
        assertTrue(myMap.containsKey(CHAVE_2));
    }

    @Test
    void naoDeveriaConfirmarExistenciaDeChaveQuandoElaNaoEstiverPresente() {
        assertFalse(myMap.containsKey(CHAVE_INEXISTENTE));
    }

    @Test
    void deveriaRetornarTamanhoCorretoAposAdicao() {
        myMap.put(CHAVE_4, VALOR_4);
        assertEquals(4, myMap.size());
    }

    @Test
    void deveriaRetornarTamanhoCorretoAposRemocao() {
        myMap.remove(CHAVE_2);
        assertEquals(2, myMap.size());
    }

    @Test
    void naoDeveriaRemoverElementoComValorNull() {
        boolean resultado = myMap.remove(null);
        assertFalse(resultado);
        assertEquals(3, myMap.size());
    }

    @Test
    void deveriaRetornarTamanhoZeroAposRemoverTodosOsElementos() {
        myMap.remove(CHAVE_1);
        myMap.remove(CHAVE_2);
        myMap.remove(CHAVE_3);
        assertEquals(0, myMap.size());
    }
}
