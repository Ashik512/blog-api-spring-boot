package com.blog.demo.common.controllers;

import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import com.blog.demo.common.constants.ApplicationConstant;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.request.MessageResponse;
import com.blog.demo.common.payloads.response.PageData;
import com.blog.demo.common.services.IService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public class AbstractController<E extends AbstractDomainBasedEntity, D extends IDto> implements IController<E ,D>  {

    protected final IService<E, D> service;

    public AbstractController(IService<E, D> service) {
        this.service = service;
    }

    @Override
    public PageData getAll(@Nullable @RequestParam(value = "active", defaultValue = "true") Boolean isActive,
                         @PageableDefault(sort = ApplicationConstant.DEFAULT_SORT,
                         direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getAll(isActive, pageable);
    }

    @Override
    @PostMapping
    public ResponseEntity<MessageResponse> create(@Valid @RequestBody D d) {
        return ResponseEntity.ok(new MessageResponse(ApplicationConstant.CREATED, service.create(d).getId()));
    }

    @Override
    public ResponseEntity<MessageResponse> update(@Valid @RequestBody D d, @PathVariable Long id) {
        return null;
    }

    @Override
    public ResponseEntity<MessageResponse> updateActiveStatus(Long id, Boolean isActive) {
        return null;
    }

    @Override
    public <T> T getSingle(Long id) {
        return null;
    }
}
