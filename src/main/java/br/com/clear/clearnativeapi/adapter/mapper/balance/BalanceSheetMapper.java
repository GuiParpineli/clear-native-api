package br.com.clear.clearnativeapi.adapter.mapper.balance;

import br.com.clear.clearnativeapi.adapter.mapper.account.AccountMapper;
import br.com.clear.clearnativeapi.adapter.mapper.company.CompanyMapper;
import br.com.clear.clearnativeapi.adapter.mapper.composition.CompositionsMapper;
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

    public static BalanceSheet toModel(BalanceSheetRequestDto dto) {
        LocalDate now = LocalDate.now();
        return new BalanceSheet(
                now.getMonthValue(),
                now.getYear(),
                new Company(dto.companyId()),
                BalanceStatus.OPEN,
                new Account(dto.accountId()),
                dto.compositions().stream().map(CompositionsMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static BalanceSheetEntity toEntity(BalanceSheet request) {
        CompanyEntity company = new CompanyEntity(request.getId());
        AccountEntity account = new AccountEntity(request.getId());
        BalanceSheetEntity entity = new BalanceSheetEntity();
        entity.setId(request.getId());
        entity.setMonth(request.getMonth());
        entity.setYear(request.getYear());
        entity.setStatus(request.getStatus().name());
        entity.setCompany(company);
        entity.setAccount(account);
        entity.setCompositions(request.getCompositions().stream()
                .map(CompositionsMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}
