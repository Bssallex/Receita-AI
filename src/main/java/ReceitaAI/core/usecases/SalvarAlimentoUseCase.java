package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;

public interface SalvarAlimentoUseCase {

    Receita execute(Receita receita);
}
