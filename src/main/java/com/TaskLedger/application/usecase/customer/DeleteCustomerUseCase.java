package com.TaskLedger.application.usecase.customer;

import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.service.CrudService;
import com.TaskLedger.domain.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CrudService crudService;
    private final CustomerGateway customerGateway;

    public ResponseHttpDTO<String> execute(UUID customerId, Locale locale) {
        return crudService.deleteResourceById(customerId,customerGateway,locale);
    }
}
