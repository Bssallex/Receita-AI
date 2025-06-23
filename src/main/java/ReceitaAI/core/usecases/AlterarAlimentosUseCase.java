package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;

import java.util.Optional;

public interface AlterarAlimentosUseCase {

    Optional<Receita> execute(Long id, Receita receita);
}
