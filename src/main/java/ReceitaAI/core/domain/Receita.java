package ReceitaAI.core.domain;

import java.time.LocalDate;

public record Receita(Long id, String ingredientes, String quantidade, LocalDate validade) {
}
