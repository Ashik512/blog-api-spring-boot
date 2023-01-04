package com.blog.demo.common.services;

import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import com.blog.demo.common.constants.ErrorId;
import com.blog.demo.common.exceptions.BlogServerException;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.response.PageData;
import com.blog.demo.common.repository.AbstractRepository;
import com.blog.demo.common.utils.Helper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractService<E extends AbstractDomainBasedEntity, D extends IDto> implements IService<E, D> {

    private final AbstractRepository<E> repository;

    protected AbstractService(AbstractRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public PageData getAll(Boolean isActive, Pageable pageable) {
        Page<E> pagedData = repository.findAllByIsActive(isActive,pageable);
        List<Object> models = pagedData.getContent().stream()
                .map(m -> convertToResponseDto(m))
                .collect(Collectors.toList());
        return PageData.builder()
                .model(models)
                .totalPages(pagedData.getTotalPages())
                .totalElements(pagedData.getTotalElements())
                .currentPage(pageable.getPageNumber() + 1)
                .build();
    }

    @Override
    public E create(D d) {
        //validateClientData(d, null);
        E entity = convertToEntity(d);
        return saveItem(entity);
    }

    @Override
    public E findById(Long id) {
        return null;
    }

    @Override
    public E update(D d, Long id) {
        return null;
    }

    @Override
    public void updateActiveStatus(Long id, Boolean isActive) {

    }

    protected abstract E convertToEntity(D d);

    protected abstract E updateEntity(D dto, E entity);

    protected abstract <T> T convertToResponseDto(E e);

    private E saveItem(E entity) {
        try {
            return repository.save(entity);
        }catch (Exception e) {
            String name = entity.getClass().getSimpleName();
            throw  BlogServerException.dataSaveException(Helper.createDynamicCode(ErrorId.DATA_NOT_SAVED_DYNAMIC, name));
        }
    }

}
