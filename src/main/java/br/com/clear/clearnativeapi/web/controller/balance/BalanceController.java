package br.com.clear.clearnativeapi.web.controller.balance;

import br.com.clear.clearnativeapi.adapter.service.BalanceUseCaseAdapter;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;
import br.com.clear.clearnativeapi.web.shared.dto.DefaultSuccessDto;
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
    public ResponseEntity<BalanceSheetDto> findById(@RequestHeader Long companyID, @RequestParam Long id) {
        return ResponseEntity.ok(useCase.getBalanceById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BalanceSheetDto>> getAllByCompany(
            @RequestHeader Long companyId,
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        return ResponseEntity.ok(useCase.getBalanceByMonthAndYear(companyId, month, year));
    }

    @PostMapping
    public ResponseEntity<Void> createBalance(@RequestHeader Long companyId, @RequestBody BalanceSheetRequestDto dto) {
        Long createdId = useCase.createBalance(companyId, dto);
        return ResponseEntity.created(URI.create("/public/balance/" + createdId)).build();
    }

    @PatchMapping("/update")
    public ResponseEntity<DefaultSuccessDto> updateBalance(@RequestHeader Long companyId, @RequestBody BalanceSheetRequestDto dto) {
        return ResponseEntity.ok(useCase.updateBalance(companyId, dto));
    }

    @PatchMapping("/close")
    public ResponseEntity<DefaultSuccessDto> closeBalance(@RequestHeader Long companyID, @RequestParam Long id) {
        return ResponseEntity.ok(useCase.closeBalance(companyID, id));
    }
}
