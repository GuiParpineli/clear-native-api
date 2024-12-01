package br.com.clear.clearnativeapi.controller.responsible;

import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.controller.dto.request.CreateResponsibleDto;
import br.com.clear.clearnativeapi.domain.service.responsible.ResponsibleUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "responsible", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Responsible", description = "Responsible operations")
public class ResponsibleController {
    private final ResponsibleUseCase useCase;

    public ResponsibleController(ResponsibleUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponsibleDto> createResponsible(@RequestBody CreateResponsibleDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.createResponsible(dto.toModel()));
    }
}
