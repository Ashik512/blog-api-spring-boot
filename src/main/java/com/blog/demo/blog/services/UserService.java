package com.blog.demo.blog.services;

import com.blog.demo.blog.entities.User;
import com.blog.demo.blog.payloads.UserDto;
import com.blog.demo.blog.payloads.search.IdQuerySearchDto;
import com.blog.demo.blog.repositories.UserRepository;
import com.blog.demo.common.repository.AbstractRepository;
import com.blog.demo.common.services.AbstractSearchService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractSearchService<User, UserDto, IdQuerySearchDto> {

    private final UserRepository repository;

    protected UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    protected User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;
    }

    @Override
    protected User updateEntity(UserDto dto, User entity) {
        return null;
    }

    @Override
    protected <T> T convertToResponseDto(User user) {
        return null;
    }
}
