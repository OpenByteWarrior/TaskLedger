package com.TaskLedger.infrastructure.peristence.repository.employee;

import com.TaskLedger.infrastructure.peristence.entity.employee.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TitleRepository extends JpaRepository<Title, UUID> {
}
