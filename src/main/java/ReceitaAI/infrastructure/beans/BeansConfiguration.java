package ReceitaAI.infrastructure.beans;

import ReceitaAI.core.gateway.ReceitaGateway;
import ReceitaAI.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public SalvarAlimentoUseCase salvarAlimentoUseCase(ReceitaGateway gateway){
        return new SalvarAlimentoImpl(gateway);
    }

    @Bean
    public ListarAlimentosUseCase listarAlimentosUseCase(ReceitaGateway gateway){
        return new ListarAlimentosImpl(gateway);
    }

    @Bean
    public AlterarAlimentosUseCase alterarAlimentosUseCase(ReceitaGateway gateway){
        return new AlterarAlimentosImpl(gateway);
    }

    @Bean
    public DeletarAlimentoUseCase deletarAlimentoUseCase(ReceitaGateway gateway){
        return new DeletarAlimentosImpl(gateway);
    }
}
