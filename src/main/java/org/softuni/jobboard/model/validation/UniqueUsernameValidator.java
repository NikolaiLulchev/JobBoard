package org.softuni.jobboard.model.validation;

import org.softuni.jobboard.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  private final UserRepository userRepository;

  public UniqueUsernameValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    return userRepository.
        findByUsername(value).
        isEmpty();
  }
}
