package com.validator;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

  public ValidationResult validatePassword(String pwd) {

    ValidationResult validationResult = new ValidationResult();
    validationResult.setRes(true);
    List<String> validationErrors = new ArrayList<>();

    //define the validation rules here 

    validationResult.setValidationErrors(String.join(",", validationErrors));
    return validationResult;
  }

}
