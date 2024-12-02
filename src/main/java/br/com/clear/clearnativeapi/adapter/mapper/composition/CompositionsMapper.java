package br.com.clear.clearnativeapi.adapter.mapper.composition;

import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.adapter.mapper.responsible.ResponsibleMapper;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.data.entity.CompositionEntity;
import br.com.clear.clearnativeapi.domain.model.Composition;

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
                compositionEntity.getEmissionDate(),
                compositionEntity.getDueDate(),
                compositionEntity.getIss(),
                compositionEntity.getInss(),
                compositionEntity.getIrrf(),
                compositionEntity.getCsrf(),
                compositionEntity.getCredit(),
                compositionEntity.getDebit(),
                compositionEntity.getHistory(),
                ResponsibleMapper.toModel(compositionEntity.getResponsible()),
                BalanceSheetMapper.toModel(compositionEntity.getBalanceSheet())
        );
    }
}
