package ReceitaAI.infrastructure.mapper;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.infrastructure.persistence.ReceitaEntity;
import org.springframework.stereotype.Component;

@Component
public class ReceitaEntityMapper {

    public ReceitaEntity toEntity(Receita receita){
        return new ReceitaEntity(
                receita.id(),
                receita.ingredientes(),
                receita.quantidade(),
                receita.validade()
                );
    }

    public Receita toDomain(ReceitaEntity entity){
        return new Receita(
                entity.getId(),
                entity.getIngredientes(),
                entity.getQuantidade(),
                entity.getValidade()
                );
    }
}
