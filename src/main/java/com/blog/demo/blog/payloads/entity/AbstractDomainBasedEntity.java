package com.blog.demo.blog.payloads.entity;

import com.blog.demo.common.entity.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AbstractDomainBasedEntity implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_active", columnDefinition = "bit default 1", nullable = false)
    private Boolean isActive = true;

}
