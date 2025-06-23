package ReceitaAI.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Map<String, String>> exception(NotFoundExceptions notFoundExceptions){

        Map<String, String> notFound = new HashMap<>();
        notFound.put("Erro", notFoundExceptions.getMessage());
        notFound.put("Mensagem", "O evento solicitado não foi encontrado. Verifique o identificador e tente novamente.");
        return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
}
