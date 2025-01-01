package com.TaskLedger.application.service;

import com.TaskLedger.application.dto.response.ResponseHttpDTO;
import com.TaskLedger.domain.Gateway;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CrudService {
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;

    public <T, K> ResponseHttpDTO<T> create(K entity, Gateway<K> gateway, Class<T> targetClass, Locale locale) {
        try {
            K objectSave = gateway.save(entity);
            T objectDTO = modelMapper.map(objectSave, targetClass);
            return new ResponseHttpDTO<>(HttpStatus.OK , messageSource.getMessage("info.crud.service.create.success",null,locale), objectDTO);
        } catch (DataAccessException e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR,  messageSource.getMessage("info.crud.service.create.error.db",new Object[]{e.getMessage()},locale), null);
        } catch (Exception e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR,  messageSource.getMessage("error.general",new Object[]{e.getMessage()},locale), null);
        }
    }

    public <T, K> ResponseHttpDTO<List<T>> getAllResource(Gateway<K> gateway, Class<T> targetClass, Locale locale) {
        {
            try {
                List<T> allResource = gateway.findAll().stream()
                        .map(value -> modelMapper.map(value, targetClass)).toList();
                if (allResource.isEmpty()) {
                    return new ResponseHttpDTO<>(HttpStatus.NO_CONTENT, messageSource.getMessage("info.crud.service.get.all.empty",null,locale), null);
                }
                return new ResponseHttpDTO<>(HttpStatus.OK, messageSource.getMessage("info.crud.service.get.all.success",null,locale), allResource);

            } catch (DataAccessException e) {
                return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("info.crud.service.get.all.error.db",new Object[]{e.getMessage()},locale), null);
            } catch (Exception e) {
                return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("error.general",new Object[]{e.getMessage()},locale), null);
            }
        }
    }

    public <T, K> ResponseHttpDTO<T> getResourceById(UUID id, Gateway<K> gateway, Class<T> targetClass, Locale locale) {

        try {
            return gateway.findById(id).map(entity -> {
                T objectDTO = modelMapper.map(entity, targetClass);
                return new ResponseHttpDTO<>(HttpStatus.OK, messageSource.getMessage("info.crud.service.get.success",null,locale), objectDTO);
            }).orElseGet(() -> new ResponseHttpDTO<>(HttpStatus.NOT_FOUND, messageSource.getMessage("info.crud.service.empty",null,locale), null));
        } catch (DataAccessException e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("info.crud.service.get.error.db",new Object[]{e.getMessage()},locale), null);
        } catch (Exception e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("error.general",new Object[]{e.getMessage()},locale), null);
        }

    }

    public <K> ResponseHttpDTO<String> deleteResourceById(UUID id, Gateway<K> gateway, Locale locale) {
        try {
            return gateway.findById(id).map(entity -> {
                gateway.deleteById(id);
                return new ResponseHttpDTO<>(HttpStatus.OK, messageSource.getMessage("info.crud.service.delete.success",null,locale), HttpStatus.OK.getReasonPhrase());
            }).orElseGet(() -> new ResponseHttpDTO<>(HttpStatus.NOT_FOUND, messageSource.getMessage("info.crud.service.empty",null,locale), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (DataAccessException e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("info.crud.service.delete.error.db",new Object[]{e.getMessage()},locale), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("error.general",new Object[]{e.getMessage()},locale), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

    public <T, K> ResponseHttpDTO<T> updateResourceById(UUID id, T objectDTO, Gateway<K> gateway, Class<T> targetClass, Locale locale) {
        try {
            return gateway.findById(id).map(existingResource -> {
                modelMapper.map(objectDTO, existingResource);
                K updatedResource = gateway.save(existingResource);
                T updatedPermissionDTO = modelMapper.map(updatedResource, targetClass);

                return new ResponseHttpDTO<>(HttpStatus.OK, messageSource.getMessage("info.crud.service.update.success",null,locale), updatedPermissionDTO);
            }).orElseGet(() -> new ResponseHttpDTO<>(HttpStatus.NOT_FOUND, messageSource.getMessage("info.crud.service.empty",null,locale), null));
        } catch (DataAccessException e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("info.crud.service.update.error.db",new Object[]{e.getMessage()},locale), null);
        } catch (Exception e) {
            return new ResponseHttpDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("error.general",new Object[]{e.getMessage()},locale), null);
        }
    }
}