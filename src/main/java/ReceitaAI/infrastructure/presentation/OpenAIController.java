package ReceitaAI.infrastructure.presentation;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.infrastructure.gateway.RepositoryGateway;
import ReceitaAI.infrastructure.mapper.ReceitaEntityMapper;
import ReceitaAI.infrastructure.openAI.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpenAIController {

    private final RepositoryGateway gateway;
    private final OpenAIService service;
    private final ReceitaEntityMapper mapper;

    @GetMapping("/gerar")
    public Mono<ResponseEntity<String>> receitaAI(){
        List<Receita> receita = gateway.listarAlimentos();

        return service.receita(receita)
                .map(r -> ResponseEntity.ok(r))
                .defaultIfEmpty(ResponseEntity.noContent().build());

    }

}
