package com.blog.demo.common.services;

import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.SDto;
import com.blog.demo.common.payloads.response.PageData;
import com.blog.demo.common.repository.AbstractRepository;

import java.awt.print.Pageable;

public abstract class AbstractSearchService<E extends AbstractDomainBasedEntity, D extends IDto, S extends SDto>
        extends AbstractService<E,D> implements ISearchService<E, D, S> {

    private final AbstractRepository<E> repository;
    protected AbstractSearchService(AbstractRepository<E> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public PageData search(S searchDto, Pageable pageable) {
        return null;
    }
}
