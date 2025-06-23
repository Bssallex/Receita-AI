package ReceitaAI.core.gateway;

import ReceitaAI.core.domain.Receita;

import java.util.List;

public interface ReceitaGateway {

    Receita salvarAlimento(Receita receita);
    List<Receita> listarAlimentos();
}
