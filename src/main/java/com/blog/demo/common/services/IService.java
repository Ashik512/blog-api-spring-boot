package com.blog.demo.common.services;

import com.blog.demo.common.entity.AbstractEntity;
import com.blog.demo.common.payloads.IDto;
import com.blog.demo.common.payloads.response.PageData;
import org.springframework.data.domain.Pageable;

public interface IService<E extends AbstractEntity, D extends IDto> {

    E create(D d);

    E findById(Long id);

    E update(D d, Long id);

    PageData getAll(Boolean isActive, Pageable pageable);

    void updateActiveStatus(Long id, Boolean isActive);

}
