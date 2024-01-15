package com.validator;

import org.junit.Assert;
import org.junit.Test;

public class PasswordValidatorTest {


  @Test
  public void shouldValidatePassword() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertTrue(passwordValidator.validatePassword("Password@123").res);
  }

  @Test
  public void shouldValidatePasswordLength() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertTrue(passwordValidator.validatePassword("Password@123").res);
    Assert.assertFalse(passwordValidator.validatePassword("Pwd@123").res);
    Assert.assertEquals(passwordValidator.validatePassword("Pwd@123").getValidationErrors(),
        "Password must be at least 8 characters");
  }

  @Test
  public void shouldValidatePasswordContainsNumericChar() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertTrue(passwordValidator.validatePassword("Password@123").res);
    Assert.assertFalse(passwordValidator.validatePassword("Password!@").res);
    Assert.assertEquals(passwordValidator.validatePassword("Password!@").getValidationErrors(),
        "The password must contain at least 1 numbers");

  }

  @Test
  public void shouldValidatePasswordContainsCapitalChar() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertTrue(passwordValidator.validatePassword("Password@123").res);
    Assert.assertFalse(passwordValidator.validatePassword("password@123").res);
    Assert.assertEquals(passwordValidator.validatePassword("password@123").getValidationErrors(),
        "password must contain at least one capital letter");
  }


  @Test
  public void shouldValidateMultipleValidationErrors() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertFalse(passwordValidator.validatePassword("password").res);
    Assert.assertEquals(passwordValidator.validatePassword("password").getValidationErrors(),
        "The password must contain at least 1 numbers,password must contain at least one capital letter");
  }

  /*@Test
  public void shouldValidateSpecialChar() {
    PasswordValidator passwordValidator = new PasswordValidator();
    Assert.assertTrue(passwordValidator.validatePassword("Password@123").res);
    Assert.assertFalse(passwordValidator.validatePassword("Password123").res);
  }*/

}
