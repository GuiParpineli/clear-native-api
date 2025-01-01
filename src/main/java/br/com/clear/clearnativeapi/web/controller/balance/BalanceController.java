package br.com.clear.clearnativeapi.web.controller.balance;

import br.com.clear.clearnativeapi.adapter.service.balance.BalanceUseCaseAdapter;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;
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
    private final BalanceUseCaseAdapter useCase;

    public BalanceController(BalanceUseCaseAdapter useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<BalanceSheetDto> findById(@RequestParam Long id) {
        return ResponseEntity.ok(useCase.getBalanceById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BalanceSheetDto>> getAllByCompany(
            @RequestParam Long companyId, @RequestParam Integer month, @RequestParam Integer year
    ) {
        return ResponseEntity.ok(useCase.getBalanceByCompanyDtoAndMonthAndYear(companyId, month, year));
    }

    @PostMapping
    public ResponseEntity<Void> createBalance(@RequestBody BalanceSheetRequestDto dto) {
        Long createdId = useCase.createBalance(dto);
        return ResponseEntity.created(URI.create("/public/balance/" + createdId)).build();
    }
}
