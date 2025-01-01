package com.TaskLedger.infrastructure.peristence.adapter.report;

import com.TaskLedger.domain.ReportGateway;
import com.TaskLedger.infrastructure.peristence.entity.report.Report;
import com.TaskLedger.infrastructure.peristence.repository.report.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ReportAdapter implements ReportGateway {

        private final ReportRepository reportRepository;

        @Override
        public Report save(Report report) {
            return reportRepository.save(report);
        }

        @Override
        public List<Report> findAll() {
            return reportRepository.findAll();
        }

        @Override
        public Optional<Report> findById(UUID id) {
            return reportRepository.findById(id);
        }

        @Override
        public void deleteById(UUID id) {
            reportRepository.deleteById(id);
        }

}
