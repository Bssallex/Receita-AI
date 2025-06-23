package ReceitaAI.infrastructure.presentation;

import ReceitaAI.core.domain.Receita;
import ReceitaAI.core.usecases.ListarAlimentosUseCase;
import ReceitaAI.core.usecases.SalvarAlimentoUseCase;
import ReceitaAI.infrastructure.dtos.ReceitaDto;
import ReceitaAI.infrastructure.mapper.ReceitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ReceitaController {

    private final SalvarAlimentoUseCase salvarAlimentoUseCase;
    private final ListarAlimentosUseCase listarAlimentosUseCase;

    private final ReceitaMapper mapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarAlimento(@RequestBody ReceitaDto receita){
        Receita salvar = salvarAlimentoUseCase.execute(mapper.toDomain(receita));

        Map<String, Object> map = new HashMap<>();
        map.put("Mensagem", "Alimento armazenado");
        map.put("Alimento", mapper.toDto(salvar));
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaDto>> listarAlimentos(){
        List<Receita> listar = listarAlimentosUseCase.execute();
        return ResponseEntity.ok(listar.stream().map(mapper::toDto).toList());
    }
}
