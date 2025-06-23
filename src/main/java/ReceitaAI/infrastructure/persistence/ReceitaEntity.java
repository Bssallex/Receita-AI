package ReceitaAI.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ingredientes;

    String quantidade;

    LocalDate validade;
}
