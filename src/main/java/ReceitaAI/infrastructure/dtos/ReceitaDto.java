package ReceitaAI.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ReceitaDto(
        Long id,
        String ingredientes,
        String quantidade,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate validade
 ){
}
