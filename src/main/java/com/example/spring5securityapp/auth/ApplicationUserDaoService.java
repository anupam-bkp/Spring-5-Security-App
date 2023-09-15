package com.example.spring5securityapp.auth;

import java.util.Optional;

public interface ApplicationUserDaoService {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
