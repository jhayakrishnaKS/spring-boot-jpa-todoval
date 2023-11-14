package com.jkay.springbootjpatodoval.Service;

import com.jkay.springbootjpatodoval.Model.AppUser;
import com.jkay.springbootjpatodoval.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser validate(AppUser appuser){
        AppUser appUser=appUserRepository.findUserByUserNameAndPassword(appuser.getUsername(),appuser.getPassword());
        return appUser;
    }

    public AppUser register(AppUser appUser) {

        return appUserRepository.save(appUser);
    }
}
