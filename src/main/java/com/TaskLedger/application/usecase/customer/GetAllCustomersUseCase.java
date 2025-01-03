package com.TaskLedger.application.usecase.customer;

import com.TaskLedger.application.dto.common.CustomerDTO;
import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.service.CrudService;
import com.TaskLedger.domain.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class GetAllCustomersUseCase {

    private final CrudService crudService;
    private final CustomerGateway customerGateway;

    public ResponseHttpDTO<List<CustomerDTO>> execute(Locale locale) {
        return crudService.getAllResource(customerGateway, CustomerDTO.class,locale);
    }

}
