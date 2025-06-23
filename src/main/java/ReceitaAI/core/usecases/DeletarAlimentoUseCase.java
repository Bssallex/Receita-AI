package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;

import java.util.Optional;

public interface DeletarAlimentoUseCase {

    Optional<Receita> execute(Long id);
}
