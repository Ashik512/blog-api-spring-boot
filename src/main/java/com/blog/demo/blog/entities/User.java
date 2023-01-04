package com.blog.demo.blog.entities;


import com.blog.demo.blog.payloads.entity.AbstractDomainBasedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractDomainBasedEntity {
    @Column(nullable = false, length = 100)
    String name;
    String email;
    String Password;
    String about;


}
