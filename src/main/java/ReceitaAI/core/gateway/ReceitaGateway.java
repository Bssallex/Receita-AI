package ReceitaAI.core.gateway;

import ReceitaAI.core.domain.Receita;

public interface ReceitaGateway {

    Receita salvarAlimento(Receita receita);
}
