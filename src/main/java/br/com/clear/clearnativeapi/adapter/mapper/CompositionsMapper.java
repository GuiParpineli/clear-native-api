package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompositionEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import br.com.clear.clearnativeapi.web.controller.dto.CompositionDto;

public abstract class CompositionsMapper {
    public static CompositionDto toDto(Composition compositions) {
        return new CompositionDto(
                compositions.getId(),
                compositions.getTaxNoteNumber(),
                compositions.getEmissionDate(),
                compositions.getDueDate(),
                compositions.getIss(),
                compositions.getInss(),
                compositions.getIrrf(),
                compositions.getCsrf(),
                compositions.getCredit(),
                compositions.getDebit(),
                compositions.getHistory(),
                ResponsibleMapper.toDto(compositions.getResponsible())
        );
    }

    public static Composition toModel(CompositionEntity compositionEntity) {
        return new Composition(
                compositionEntity.getId(),
                compositionEntity.getTaxNoteNumber(),
                compositionEntity.getIss(),
                compositionEntity.getInss(),
                compositionEntity.getIrrf(),
                compositionEntity.getCsrf(),
                compositionEntity.getCredit(),
                compositionEntity.getDebit(),
                compositionEntity.getHistory(),
                compositionEntity.getEmissionDate(),
                compositionEntity.getDueDate(),
                ResponsibleMapper.toModel(compositionEntity.getResponsible()),
                BalanceSheetMapper.toModel(compositionEntity.getBalanceSheet())
        );
    }

    public static Composition toModel(CompositionDto compositionEntity) {
        return new Composition(
                compositionEntity.id(),
                compositionEntity.taxNoteNumber(),
                compositionEntity.iss(),
                compositionEntity.inss(),
                compositionEntity.irrf(),
                compositionEntity.csrf(),
                compositionEntity.credit(),
                compositionEntity.debit(),
                compositionEntity.history(),
                compositionEntity.emissionDate(),
                compositionEntity.dueDate(),
                new Responsible(compositionEntity.responsible().id()),
                new BalanceSheet()
        );
    }

    public static CompositionEntity toEntity(Composition composition) {
        return new CompositionEntity(
                composition.getId(),
                composition.getTaxNoteNumber(),
                composition.getIss(),
                composition.getInss(),
                composition.getIrrf(),
                composition.getCsrf(),
                composition.getCredit(),
                composition.getDebit(),
                composition.getHistory(),
                composition.getEmissionDate(),
                composition.getDueDate(),
                new ResponsibleEntity(composition.getResponsible().getId()),
                new BalanceSheetEntity(composition.getBalance().getId())
        );
    }
}
