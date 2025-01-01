package com.TaskLedger.infrastructure.peristence.adapter.report;

import com.TaskLedger.domain.DayGateway;
import com.TaskLedger.infrastructure.peristence.entity.report.Day;
import com.TaskLedger.infrastructure.peristence.repository.report.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DayAdapter implements DayGateway {

    private final DayRepository dayRepository;

    @Override
    public Day save(Day day) {
        return dayRepository.save(day);
    }

    @Override
    public Optional<Day> findById(UUID id) {
        return dayRepository.findById(id);
    }

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        dayRepository.deleteById(id);
    }
}
