package com.blog.demo.common.controllers;

import com.blog.demo.common.entity.AbstractEntity;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.SDto;
import com.blog.demo.common.payloads.response.PageData;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ISearchController<E extends AbstractEntity, D extends IDto, S extends SDto> {

    ResponseEntity<PageData> search(S s, Pageable pageable);
}
