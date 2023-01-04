package com.blog.demo.common.repository;

import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<E extends AbstractDomainBasedEntity>
        extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

    Page<E> findAllByIsActive(Boolean isActive, Pageable pageable);

}
