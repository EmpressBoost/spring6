package com.atguigu.spring6.validator.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class Myservice {

    public String testUser(@NotNull @Valid User user){
        return user.toString();
    }
}
