package com.kunal.AuthService.Controller;

import com.kunal.AuthService.DTO.UserCreationRequest;
import com.kunal.AuthService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth/user")
public class UserController {

UserService userService;
Logger logger = LoggerFactory.getLogger(this.getClass());
UserController(UserService userService){
    this.userService=userService;
}


    @PostMapping("/create")
    public void createUser(@RequestBody UserCreationRequest user){
        try{
            logger.info("UserCreationRequest {}", user);
            userService.saveUser(user);
        }catch(Exception e){
            logger.error("Error",e);
        }
    }

}
