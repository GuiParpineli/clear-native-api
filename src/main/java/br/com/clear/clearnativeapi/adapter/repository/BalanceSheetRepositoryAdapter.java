package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.adapter.mapper.composition.CompositionsMapper;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.balance.BalanceSheetJpaRepository;
import br.com.clear.clearnativeapi.infrastructure.repository.company.CompanyJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceSheetRepositoryAdapter implements BalanceSheetRepository {
    private final BalanceSheetJpaRepository repository;
    private final CompanyJpaRepository companyRepository;

    public BalanceSheetRepositoryAdapter(BalanceSheetJpaRepository repository, CompanyJpaRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void update(BalanceSheet request) {
        BalanceSheetEntity entity = BalanceSheetMapper.toEntity(request);
        repository.saveAndFlush(entity);
    }

    @Override
    public BalanceSheet save(BalanceSheet balanceSheet) {
        CompanyEntity companyEntity = companyRepository.findById(balanceSheet.getCompany().getId()).orElseThrow();

        BalanceSheetEntity entity = new BalanceSheetEntity();
        entity.setMonth(balanceSheet.getMonth());
        entity.setYear(balanceSheet.getYear());
        entity.setStatus(balanceSheet.getStatus().name());
        entity.setCompany(companyEntity);
        entity.setCompositions(balanceSheet.getCompositions().stream()
                .map(CompositionsMapper::toEntity)
                .collect(Collectors.toSet()));

        return BalanceSheetMapper.toModel(repository.save(entity));
    }

    @Override
    public BalanceSheet findById(Long id) {
        return BalanceSheetMapper.toModel(repository.findById(id).orElseThrow());
    }

    @Override
    public void delete(BalanceSheet request) {
        repository.deleteById(request.getId());
    }

    @Override
    public List<BalanceSheet> findAll(Company company) {
        CompanyEntity companyEntity = companyRepository.findById(company.getId()).orElseThrow();
        return repository.findAllByCompany(companyEntity);
    }

    @Override
    public BalanceSheet getBalanceByResponsible(Responsible responsible) {
        return null;
    }

    @Override
    public List<BalanceSheet> getByStatus(String status) {
        return List.of();
    }

    @Override
    public List<BalanceSheet> getByMonth(Company company, String month) {
        return List.of();
    }
}
