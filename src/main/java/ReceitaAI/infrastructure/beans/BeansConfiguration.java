package ReceitaAI.infrastructure.beans;

import ReceitaAI.core.gateway.ReceitaGateway;
import ReceitaAI.core.usecases.SalvarAlimentoImpl;
import ReceitaAI.core.usecases.SalvarAlimentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public SalvarAlimentoUseCase salvarAlimentoUseCase(ReceitaGateway gateway){
        return new SalvarAlimentoImpl(gateway);
    }
}
