package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;

import java.util.Optional;

public class DeletarAlimentosImpl implements DeletarAlimentoUseCase{

    private final ReceitaGateway gateway;

    public DeletarAlimentosImpl(ReceitaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<Receita> execute(Long id) {
        return gateway.deletarAlimentos(id);
    }
}
