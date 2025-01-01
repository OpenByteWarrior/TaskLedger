package com.TaskLedger.infrastructure.peristence.adapter.report;

import com.TaskLedger.domain.MonthGateway;
import com.TaskLedger.infrastructure.peristence.entity.report.Month;
import com.TaskLedger.infrastructure.peristence.repository.report.MonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MonthAdapter implements MonthGateway {

    private final MonthRepository monthRepository;

    @Override
    public Month save(Month month) {
        return monthRepository.save(month);
    }

    @Override
    public Optional<Month> findById(UUID id) {
        return monthRepository.findById(id);
    }

    @Override
    public List<Month> findAll() {
        return monthRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        monthRepository.deleteById(id);
    }
}
