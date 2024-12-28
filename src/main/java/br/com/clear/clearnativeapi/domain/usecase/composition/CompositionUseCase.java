package br.com.clear.clearnativeapi.domain.usecase.composition;


import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Composition;

public interface CompositionUseCase {
    Composition createComposition(BalanceSheet balanceSheet, Composition composition);

    Composition updateComposition(Composition composition);

    Composition getCompositionById(Long id);

    void deleteComposition(Long id);
}
