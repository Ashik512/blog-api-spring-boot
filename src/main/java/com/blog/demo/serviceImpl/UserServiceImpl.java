package com.blog.demo.serviceImpl;

import com.blog.demo.entities.User;
import com.blog.demo.exceptions.ResourceNotFoundException;
import com.blog.demo.payloads.UserDto;
import com.blog.demo.repositories.UserRepo;
import com.blog.demo.services.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements AbstractService<UserDto> {
    private UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepo.save(user);

        return this.convertToDto(savedUser);
    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        User convert = convertToUpdateEntity(user, userDto);
        User updatedUser = userRepo.save(convert);
        return convertToDto(updatedUser);
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return convertToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> convertToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void delete(Integer id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepo.delete(user);
    }

    private User convertToEntity(UserDto userDto) {
        return populateEntity(new User(), userDto);
    }

    private User convertToUpdateEntity(User user, UserDto userDto) {
        return populateEntity(user,userDto);
    }

    private User populateEntity(User user, UserDto userDto) {
        //user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getPassword());

        return userDto;
    }

}
