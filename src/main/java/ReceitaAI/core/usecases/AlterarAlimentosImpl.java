package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;

import java.util.Optional;

public class AlterarAlimentosImpl implements AlterarAlimentosUseCase{

    private final ReceitaGateway gateway;

    public AlterarAlimentosImpl(ReceitaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<Receita> execute(Long id, Receita receita) {
        return gateway.alterarAlimento(id, receita);
    }
}
