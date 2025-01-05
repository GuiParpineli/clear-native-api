package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.adapter.mapper.BalanceSheetMapper;
import br.com.clear.clearnativeapi.adapter.mapper.CompositionsMapper;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.repository.BalanceSheetRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.BalanceSheetJpaRepository;
import br.com.clear.clearnativeapi.infrastructure.repository.CompanyJpaRepository;
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
        return repository.findAllByCompany(companyEntity).stream()
                .map(BalanceSheetMapper::toModel)
                .toList();
    }

    @Override
    public List<BalanceSheet> getByStatus(Company company, String status) {
        CompanyEntity companyEntity = companyRepository.findById(company.getId()).orElseThrow();
        return repository.findByStatus(companyEntity, status).stream()
                .map(BalanceSheetMapper::toModel)
                .toList();
    }

    @Override
    public List<BalanceSheet> getByMonth(Company company, String month) {
        CompanyEntity companyEntity = companyRepository.findById(company.getId()).orElseThrow();
        return repository.findByMonth(companyEntity, month).stream()
                .map(BalanceSheetMapper::toModel)
                .toList();
    }

    @Override
    public List<BalanceSheet> findByMonthAndYear(Long companyId, Integer month, Integer year) {
        return repository.findByMonthAndYear(companyId, month, year).stream()
                .map(BalanceSheetMapper::toModel)
                .toList();
    }

    @Override
    public BalanceSheet findByCompanyAndId(Long companyID, Long id) {
        return BalanceSheetMapper.toModel(repository.findByCompanyAndId(companyID, id).orElseThrow());
    }
}
