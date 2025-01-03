package com.TaskLedger.infrastructure.api;

import com.TaskLedger.application.dto.common.CustomerDTO;
import com.TaskLedger.application.dto.request.RequestCustomerDTO;
import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.application.usecase.customer.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping
    public ResponseHttpDTO<CustomerDTO> createCustomer(@RequestBody RequestCustomerDTO requestCustomerDTO,HttpServletRequest request) {
        try{
            return createCustomerUseCase.execute(requestCustomerDTO,request.getLocale());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseHttpDTO<List<CustomerDTO>> getCustomers(HttpServletRequest request) {
        try{
            return getAllCustomersUseCase.execute(request.getLocale());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseHttpDTO<CustomerDTO> getCustomer(@PathVariable UUID id, HttpServletRequest request) {
        try{
            return getCustomerByIdUseCase.execute(id,request.getLocale());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseHttpDTO<CustomerDTO> updateCustomer(@PathVariable UUID id, @RequestBody RequestCustomerDTO requestCustomerDTO, HttpServletRequest request) {
        try{
            return updateCustomerUseCase.execute(id,requestCustomerDTO,request.getLocale());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseHttpDTO<String> deleteCustomer(@PathVariable UUID id, HttpServletRequest request) {
        try{
            return deleteCustomerUseCase.execute(id, request.getLocale());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
