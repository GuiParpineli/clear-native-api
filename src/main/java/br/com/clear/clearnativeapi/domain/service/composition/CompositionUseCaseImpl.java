package br.com.clear.clearnativeapi.domain.service.composition;


import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Composition;
import org.springframework.stereotype.Repository;

@Repository
class CompositionUseCaseImpl implements CompositionUseCase {
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
