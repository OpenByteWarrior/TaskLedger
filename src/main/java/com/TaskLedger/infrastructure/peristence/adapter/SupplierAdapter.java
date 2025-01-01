package com.TaskLedger.infrastructure.peristence.adapter;

import com.TaskLedger.domain.SupplierGateway;
import com.TaskLedger.infrastructure.peristence.entity.Supplier;
import com.TaskLedger.infrastructure.peristence.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SupplierAdapter implements SupplierGateway {
    private final SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        supplierRepository.deleteById(id);
    }
}
