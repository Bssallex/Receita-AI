package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;

import java.util.List;

public class ListarAlimentosImpl implements ListarAlimentosUseCase{

    private final ReceitaGateway gateway;

    public ListarAlimentosImpl(ReceitaGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Receita> execute() {
        return gateway.listarAlimentos();
    }
}
