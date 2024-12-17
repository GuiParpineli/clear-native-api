package br.com.clear.clearnativeapi.controller.balance;

import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.controller.balance.dto.BalanceSheetRequestDto;
import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.domain.service.balance.BalanceUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "public/balance", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Balance", description = "Balance operations")
public class BalanceController {
    private final BalanceUseCase useCase;

    public BalanceController(BalanceUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<BalanceSheetDto> findById(@RequestParam Long id) {
        return ResponseEntity.ok(
                BalanceSheetMapper.toDto(useCase.getBalanceById(id).orElseThrow())
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<BalanceSheetDto>> getAllByCompany(@RequestParam Long companyId,
                                                                 @RequestParam Integer month,
                                                                 @RequestParam Integer year) {
        return ResponseEntity.ok(
                useCase.getBalanceByCompanyDtoAndMonthAndYear(companyId, month, year)
                        .stream().map(BalanceSheetMapper::toDto).toList()
        );
    }

    @PostMapping
    public ResponseEntity<Void> createBalance(@RequestBody BalanceSheetRequestDto dto) {
        Long createdId = useCase.createBalance(BalanceSheetMapper.toModel(dto));
        return ResponseEntity.created(URI.create("/public/balance/" + createdId)).build();
    }
}
