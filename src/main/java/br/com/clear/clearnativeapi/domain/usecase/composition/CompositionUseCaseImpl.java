package br.com.clear.clearnativeapi.domain.usecase.composition;


import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.repository.CompositionRepository;

public class CompositionUseCaseImpl implements CompositionUseCase {
    private final CompositionRepository repository;

    CompositionUseCaseImpl(CompositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Composition createComposition(BalanceSheet balanceSheet, Composition composition) {
        return null;
    }

    @Override
    public Composition updateComposition(Composition composition) {
        return null;
    }

    @Override
    public Composition getCompositionById(Long id) {
        return null;
    }

    @Override
    public void deleteComposition(Long id) {

    }
}
