package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.Account;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.infrastructure.entity.AccountEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;

import java.time.LocalDate;
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
                BalanceStatus.valueOf(entity.getStatus()),
                CompanyMapper.toModel(entity.getCompany()),
                AccountMapper.toModel(entity.getAccount()),
                entity.getCompositions().stream().map(CompositionsMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static BalanceSheet toModel(Long companyId, BalanceSheetRequestDto dto) {
        LocalDate now = LocalDate.now();
        return new BalanceSheet(
                now.getMonthValue(),
                now.getYear(),
                new Company(companyId),
                BalanceStatus.OPEN,
                new Account(dto.accountId()),
                dto.compositions().stream().map(CompositionsMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static BalanceSheetEntity toEntity(BalanceSheet balance) {
        CompanyEntity company = new CompanyEntity(balance.getId());
        AccountEntity account = new AccountEntity(balance.getId());
        BalanceSheetEntity entity = new BalanceSheetEntity();
        entity.setId(balance.getId() == null ? null : balance.getId());
        entity.setMonth(balance.getMonth());
        entity.setYear(balance.getYear());
        entity.setStatus(balance.getStatus().name());
        entity.setCompany(company);
        entity.setAccount(account);
        entity.setCompositions(balance.getCompositions().stream()
                .map(CompositionsMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}
