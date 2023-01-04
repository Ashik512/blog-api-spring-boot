package com.blog.demo.common.services;

import com.blog.demo.common.entity.AbstractEntity;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.SDto;
import com.blog.demo.common.payloads.response.PageData;

import java.awt.print.Pageable;

public interface ISearchService <E extends AbstractEntity, D extends IDto, S extends SDto> extends IService<E, D> {

    PageData search(S s, Pageable pageable);

}
