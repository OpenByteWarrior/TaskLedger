package com.TaskLedger.infrastructure.peristence.adapter;

import com.TaskLedger.domain.CustomerGateway;
import com.TaskLedger.infrastructure.peristence.entity.Customer;
import com.TaskLedger.infrastructure.peristence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerGateway {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }
}
