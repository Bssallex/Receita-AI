package ReceitaAI.core.gateway;

import ReceitaAI.core.domain.Receita;

import java.util.List;
import java.util.Optional;

public interface ReceitaGateway {

    Receita salvarAlimento(Receita receita);
    List<Receita> listarAlimentos();
    Optional<Receita> alterarAlimento(Long id, Receita receita);
    Optional<Receita> deletarAlimentos(Long id);
}
