package ReceitaAI.infrastructure.presentation;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.usecases.SalvarAlimentoUseCase;
import ReceitaAI.infrastructure.dtos.ReceitaDto;
import ReceitaAI.infrastructure.mapper.ReceitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ReceitaController {

    private final SalvarAlimentoUseCase salvarAlimentoUseCase;
    private final ReceitaMapper mapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarAlimento(@RequestBody ReceitaDto receita){
        Receita salvar = salvarAlimentoUseCase.execute(mapper.toDomain(receita));

        Map<String, Object> map = new HashMap<>();
        map.put("Mensagem", "Alimento armazenado");
        map.put("Alimento", mapper.toDto(salvar));
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }
}
