package org.softuni.jobboard.model.mapper;

import org.mapstruct.Mapper;
import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.model.dto.UserViewModel;
import org.softuni.jobboard.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

//  @Mapping(target = "age", constant = "100")
UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);
}
