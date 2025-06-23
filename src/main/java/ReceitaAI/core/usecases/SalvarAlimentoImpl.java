package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;

public class SalvarAlimentoImpl implements SalvarAlimentoUseCase{

    private final ReceitaGateway gateway;

    public SalvarAlimentoImpl(ReceitaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Receita execute(Receita receita) {
        return gateway.salvarAlimento(receita);
    }
}
