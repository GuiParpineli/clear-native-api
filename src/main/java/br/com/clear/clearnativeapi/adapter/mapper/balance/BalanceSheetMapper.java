package br.com.clear.clearnativeapi.adapter.mapper.balance;

import br.com.clear.clearnativeapi.adapter.mapper.account.AccountMapper;
import br.com.clear.clearnativeapi.adapter.mapper.company.CompanyMapper;
import br.com.clear.clearnativeapi.adapter.mapper.composition.CompositionsMapper;
import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.data.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;

import java.util.stream.Collectors;

public abstract class BalanceSheetMapper {
    public static BalanceSheetDto toDto(BalanceSheet balanceSheet) {
        return new BalanceSheetDto(
                balanceSheet.getId(),
                balanceSheet.getMonth(),
                balanceSheet.getYear(),
                CompanyMapper.toDto(balanceSheet.getCompany()),
                balanceSheet.getStatus().name(),
                AccountMapper.toDto(balanceSheet.getAccount()),
                balanceSheet.getCompositions().stream().map(CompositionsMapper::toDto).collect(Collectors.toSet())
        );
    }

    public static BalanceSheet toModel(BalanceSheetEntity entity) {
        return new BalanceSheet(
                entity.getId(),
                entity.getMonth(),
                entity.getYear(),
                CompanyMapper.toModel(entity.getCompany()),
                BalanceStatus.valueOf(entity.getStatus()),
                AccountMapper.toModel(entity.getAccount()),
                entity.getCompositions().stream().map(CompositionsMapper::toModel).collect(Collectors.toSet())
        );
    }

}