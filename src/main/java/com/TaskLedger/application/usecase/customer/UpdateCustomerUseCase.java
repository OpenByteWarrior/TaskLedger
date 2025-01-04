package com.TaskLedger.application.usecase.customer;

import com.TaskLedger.application.dto.common.CustomerDTO;
import com.TaskLedger.application.dto.request.RequestCustomerDTO;
import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.service.CrudService;
import com.TaskLedger.domain.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCustomerUseCase {

    private final CrudService crudService;
    private final CustomerGateway customerGateway;
    private final ModelMapper modelMapper;

    public ResponseHttpDTO<CustomerDTO> execute(UUID customerId, RequestCustomerDTO request, Locale locale) {
        CustomerDTO customerDTO = modelMapper.map(request, CustomerDTO.class);
        return crudService.updateResourceById(customerId,customerDTO, customerGateway, CustomerDTO.class, locale);
    }

}
