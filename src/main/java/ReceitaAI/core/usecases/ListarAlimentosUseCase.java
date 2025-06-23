package ReceitaAI.core.usecases;

import ReceitaAI.core.domain.Receita;

import java.util.List;

public interface ListarAlimentosUseCase {

    List<Receita> execute();
}
