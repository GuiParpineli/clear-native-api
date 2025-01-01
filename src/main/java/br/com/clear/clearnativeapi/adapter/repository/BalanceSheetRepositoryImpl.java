package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.adapter.configuration.exception.InvalidDataException;
import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.adapter.mapper.composition.CompositionsMapper;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.balance.BalanceSheetJpaRepository;
import br.com.clear.clearnativeapi.infrastructure.repository.company.CompanyJpaRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BalanceSheetRepositoryImpl implements BalanceSheetRepository {
    private final BalanceSheetJpaRepository repository;
    private final CompanyJpaRepository companyRepository;

    public BalanceSheetRepositoryImpl(BalanceSheetJpaRepository repository, CompanyJpaRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void update(BalanceSheet request) {

    }

    @Override
    public BalanceSheet save(BalanceSheet balanceSheet) {
        CompanyEntity companyEntity = companyRepository.findById(balanceSheet.getCompany().getId()).orElseThrow();

        BalanceSheetEntity entity = new BalanceSheetEntity();
        entity.setMonth(balanceSheet.getMonth());
        entity.setYear(balanceSheet.getYear());
        entity.setStatus(BalanceStatus.OPEN.getDescription());
        entity.setCompany(companyEntity);
        entity.setCompositions(balanceSheet.getCompositions().stream().map(CompositionsMapper::toEntity).collect(Collectors.toSet()));

        return BalanceSheetMapper.toModel(repository.save(entity));
    }

    @Override
    public BalanceSheet findById(Long id) {
        return BalanceSheetMapper.toModel(repository.findById(id).orElseThrow());
    }
}
