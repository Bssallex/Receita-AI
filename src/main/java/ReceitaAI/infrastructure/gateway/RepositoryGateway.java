package ReceitaAI.infrastructure.gateway;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;
import ReceitaAI.infrastructure.mapper.ReceitaEntityMapper;
import ReceitaAI.infrastructure.persistence.ReceitaEntity;
import ReceitaAI.infrastructure.persistence.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RepositoryGateway implements ReceitaGateway {

    private final ReceitaRepository repository;
    private final ReceitaEntityMapper mapper;

    @Override
    public Receita salvarAlimento(Receita receita) {
        ReceitaEntity salvar = repository.save(mapper.toEntity(receita));
        return mapper.toDomain(salvar);
    }

    @Override
    public List<Receita> listarAlimentos() {
        List<ReceitaEntity> listar = repository.findAll();
        return listar.stream()
                .map(mapper::toDomain)
                .toList();
    }


}
