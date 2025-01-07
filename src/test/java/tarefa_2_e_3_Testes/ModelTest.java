package tarefa_2_e_3_Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tarefa_dois_model.Model;
import tarefa_dois_model.ModelException;

class ModelTest {
    private Model model;
    private static final int ID_VALIDO = 1;
    private static final String DESCRICAO_VALIDA = "Produto de Teste";
    private static final double PRECO_VALIDO = 99.99;

    @BeforeEach
    void setUp() {
        model = new Model(ID_VALIDO, DESCRICAO_VALIDA, PRECO_VALIDO);
    }

    @Test
    void testGetSetId() {
        model.setId(2);
        assertEquals(2, model.getId());
    }

    @Test
    void testGetSetDescricao() {
        model.setDescricao("Novo Produto");
        assertEquals("Novo Produto", model.getDescricao());
    }

    @Test
    void testGetSetPreco() {
        model.setPreco(150.75);
        assertEquals(150.75, model.getPreco());
    }

    @Test
    void testModelExceptionComMensagem() {
        ModelException exception = assertThrows(ModelException.class, () -> {
            throw new ModelException("Erro no modelo");
        });
        assertEquals("Erro no modelo", exception.getMessage());
    }

    @Test
    void testModelExceptionComMensagemECausa() {
        Throwable cause = new Throwable("Causa do erro");
        ModelException exception = assertThrows(ModelException.class, () -> {
            throw new ModelException("Erro no modelo", cause);
        });
        assertEquals("Erro no modelo", exception.getMessage());
        assertEquals("Causa do erro", exception.getCause().getMessage());
    }

    @Test
    void testModelExceptionSemMensagem() {
        ModelException exception = assertThrows(ModelException.class, () -> {
            throw new ModelException();
        });
        assertEquals("Erro no modelo.", exception.getMessage());
    }

}