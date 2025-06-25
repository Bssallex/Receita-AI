package ReceitaAI.infrastructure.openAI;

import ReceitaAI.core.domain.Receita;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OpenAIService {

    private final WebClient webClient;
    private String apiKey = System.getenv("API_KEY");

    public Mono<String> receita(List<Receita> receitas) {

        String alimentos = receitas.stream()
                .map(item -> String.format("%s - Quantidade: %s, Validade: %tF",
                        item.ingredientes(), item.quantidade(), item.validade()))
                .collect(Collectors.joining("\n"));
        String prompt = "Baseado no meu banco de dados, faça uma receita com os seguintes itens:\n " + alimentos;

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o-mini",
                "store", true,
                "messages", List.of(
                        Map.of("role", "system", "content", "Você é um assistente que cria receitas"),
                        Map.of("role", "user", "content", prompt)
                )
        );

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        if (message != null) {
                            return message.get("content").toString();
                        }
                    }
                    return "Nenhuma receita foi gerada.";
                });

    }
}

