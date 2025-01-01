package com.TaskLedger.infrastructure.peristence.adapter.employee;

import com.TaskLedger.domain.TitleGateway;
import com.TaskLedger.infrastructure.peristence.entity.employee.Title;
import com.TaskLedger.infrastructure.peristence.repository.employee.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TitleAdapter implements TitleGateway {

    private final TitleRepository titleRepository;

    @Override
    public Title save(Title title) {
        return titleRepository.save(title);
    }

    @Override
    public Optional<Title> findById(UUID id) {
        return titleRepository.findById(id);
    }

    @Override
    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        titleRepository.deleteById(id);
    }
}
