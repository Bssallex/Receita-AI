package ReceitaAI.infrastructure.webClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${api.curl:https://api.openai.com/v1/chat/completions}")
    private String curlGPT;

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl(curlGPT).build();
    }
}
