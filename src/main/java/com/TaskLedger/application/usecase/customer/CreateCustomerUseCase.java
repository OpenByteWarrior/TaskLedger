package com.TaskLedger.application.usecase.customer;

import com.TaskLedger.application.dto.common.CustomerDTO;
import com.TaskLedger.application.dto.request.RequestCustomerDTO;
import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.service.CrudService;
import com.TaskLedger.domain.CustomerGateway;
import com.TaskLedger.infrastructure.peristence.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CrudService crudService;
    private final ModelMapper modelMapper;
    private final CustomerGateway customerGateway;

    public ResponseHttpDTO<CustomerDTO> execute(RequestCustomerDTO requestCustomerDTO, Locale locale) {
        Customer customer = modelMapper.map(requestCustomerDTO, Customer.class);
        return crudService.create(customer,customerGateway, CustomerDTO.class, locale);
    }

}
