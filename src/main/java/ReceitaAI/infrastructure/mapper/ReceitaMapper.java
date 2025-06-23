package ReceitaAI.infrastructure.mapper;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.infrastructure.dtos.ReceitaDto;
import org.springframework.stereotype.Component;

@Component
public class ReceitaMapper {

    public Receita toDomain(ReceitaDto dto){
        return new Receita(
                dto.id(),
                dto.ingredientes(),
                dto.quantidade(),
                dto.validade()
        );
    }

    public ReceitaDto toDto(Receita receita){
        return new ReceitaDto(
                receita.id(),
                receita.ingredientes(),
                receita.quantidade(),
                receita.validade()
        );
    }
}
