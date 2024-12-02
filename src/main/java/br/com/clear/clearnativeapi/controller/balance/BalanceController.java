package br.com.clear.clearnativeapi.controller.balance;

import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.domain.service.balance.BalanceUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public/balance", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Balance", description = "Balance operations")
public class BalanceController {
    private final BalanceUseCase useCase;

    public BalanceController(BalanceUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceSheetDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                BalanceSheetMapper.toDto(useCase.getBalanceById(id).orElseThrow())
        );
    }
}
