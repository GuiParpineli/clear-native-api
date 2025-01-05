package br.com.clear.clearnativeapi.web.controller.company;

import br.com.clear.clearnativeapi.adapter.service.CompanyServiceAdapter;
import br.com.clear.clearnativeapi.web.controller.company.dto.CompanyRequestDto;
import br.com.clear.clearnativeapi.web.shared.dto.DefaultResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/company")
@Tag(name = "Company")
public class CompanyController {
    private final CompanyServiceAdapter usecase;

    public CompanyController(CompanyServiceAdapter usecase) {
        this.usecase = usecase;
    }

    @PostMapping("/create")
    public ResponseEntity<DefaultResponseDto> registerCompany(@RequestBody CompanyRequestDto dto) {
        DefaultResponseDto response = usecase.register(dto);
        return ResponseEntity.status(response.httpStatus()).body(response);
    }
}
