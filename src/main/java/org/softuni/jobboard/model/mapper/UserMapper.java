package org.softuni.jobboard.model.mapper;

import org.mapstruct.Mapper;
import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.model.dto.UserViewModel;
import org.softuni.jobboard.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);

UserEntity userDtoToUserEntity(UserViewModel userViewModel);
}
