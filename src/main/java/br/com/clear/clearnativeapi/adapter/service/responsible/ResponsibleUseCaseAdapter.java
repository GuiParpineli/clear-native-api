package br.com.clear.clearnativeapi.adapter.service.responsible;

import br.com.clear.clearnativeapi.domain.repository.responsible.ResponsibleRepository;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCase;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCaseImpl;
import org.springframework.stereotype.Service;

@Service
public class ResponsibleUseCaseAdapter {
    private final ResponsibleUseCase useCase;

    public ResponsibleUseCaseAdapter(ResponsibleRepository repository) {
        this.useCase = new ResponsibleUseCaseImpl(repository);
    }
}
