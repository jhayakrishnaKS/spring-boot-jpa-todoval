package com.jkay.springbootjpatodoval.Controller;

import com.jkay.springbootjpatodoval.Model.AppUser;
import com.jkay.springbootjpatodoval.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class AppUserController {
    @Autowired
    public AppUserService appUserService;

    @PostMapping("/login")
    public AppUser Login(@RequestBody AppUser appUser){
        return appUserService.validate(appUser);
    }
    @PostMapping("/register")
    public AppUser Register(@RequestBody AppUser appUser){
        return appUserService.register(appUser);
    }
}
