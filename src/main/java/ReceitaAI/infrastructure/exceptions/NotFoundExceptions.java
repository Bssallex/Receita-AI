package ReceitaAI.infrastructure.exceptions;

public class NotFoundExceptions extends RuntimeException{

    public NotFoundExceptions(String message){
        super(message);
    }
}
