package ReceitaAI.infrastructure.gateway;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.gateway.ReceitaGateway;
import ReceitaAI.infrastructure.mapper.ReceitaEntityMapper;
import ReceitaAI.infrastructure.persistence.ReceitaEntity;
import ReceitaAI.infrastructure.persistence.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Receita> alterarAlimento(Long id, Receita receita) {
        Optional<ReceitaEntity> verificar = repository.findById(id);
        return verificar.map(v -> {
            v.setId(v.getId());
            v.setIngredientes(receita.ingredientes());
            v.setQuantidade(receita.quantidade());
            v.setValidade(receita.validade());

            repository.save(v);
            return mapper.toDomain(v);
        });
    }

    @Override
    public Optional<Receita> deletarAlimentos(Long id) {
        Optional<ReceitaEntity> verificar = repository.findById(id);
        return verificar.map(d -> {
            repository.delete(d);
            return mapper.toDomain(d);
        });
    }


}
