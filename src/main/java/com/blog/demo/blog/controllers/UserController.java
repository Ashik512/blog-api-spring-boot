package com.blog.demo.blog.controllers;


import com.blog.demo.blog.entities.User;
import com.blog.demo.blog.payloads.UserDto;
import com.blog.demo.blog.payloads.search.IdQuerySearchDto;
import com.blog.demo.blog.services.UserService;
import com.blog.demo.common.controllers.AbstractSearchController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController extends AbstractSearchController<User, UserDto, IdQuerySearchDto> {

    public UserController(UserService service) {
        super(service);
    }

}
