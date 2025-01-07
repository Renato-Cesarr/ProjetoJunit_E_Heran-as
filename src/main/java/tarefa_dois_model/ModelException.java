package tarefa_dois_model;

public class ModelException extends Exception {

    public ModelException(String message) {
        super(message);
    }

    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelException() {
        super("Erro no modelo.");
    }
}
 