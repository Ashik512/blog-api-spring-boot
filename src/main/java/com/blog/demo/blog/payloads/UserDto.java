package com.blog.demo.blog.payloads;

import com.blog.demo.common.payloads.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements IDto {

    private Long id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @Email
    private String email;
    @NotNull
    @Size(min = 6)
    private String password;
    private String about;

}
