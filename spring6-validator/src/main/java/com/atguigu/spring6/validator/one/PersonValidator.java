package com.atguigu.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //name 不为空
        ValidationUtils.rejectIfEmpty(errors,"name",
                "name.empty","name is empty");
        //age不能<0  不能>200
        Person person = (Person) target;
        if(person.getAge() < 0){
            errors.rejectValue("age","age.value.error","age <0");
        }else if (person.getAge() > 200){
            errors.rejectValue("age","age.value.error.old","age>200");
        }
    }
}
