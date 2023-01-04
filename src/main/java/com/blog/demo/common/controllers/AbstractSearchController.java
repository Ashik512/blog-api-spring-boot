package com.blog.demo.common.controllers;

import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.SDto;
import com.blog.demo.common.payloads.response.PageData;
import com.blog.demo.common.services.ISearchService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public abstract class AbstractSearchController<E extends AbstractDomainBasedEntity, D extends IDto ,S extends SDto>
        extends AbstractController<E, D> implements ISearchController<E, D, S> {

    protected final ISearchService<E, D, S> iSearchService;

    public AbstractSearchController(ISearchService<E, D, S> iSearchService) {
        super(iSearchService);
        this.iSearchService = iSearchService;
    }

    public ResponseEntity<PageData> search(S s, Pageable pageable) {
        return null;
    }

}
