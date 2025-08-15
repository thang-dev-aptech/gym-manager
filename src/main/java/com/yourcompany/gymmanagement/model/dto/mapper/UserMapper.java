package com.yourcompany.gymmanagement.model.dto.mapper;

import com.yourcompany.gymmanagement.model.dto.request.CreateUserRequest;
import com.yourcompany.gymmanagement.model.entity.User;

public interface UserMapper {
    public static User toEntity(CreateUserRequest dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
