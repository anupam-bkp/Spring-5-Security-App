package com.example.spring5securityapp.auth;

import com.example.spring5securityapp.security.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
@RequiredArgsConstructor
public class FakeApplicationUserDaoServiceImpl implements ApplicationUserDaoService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getAllApplicationUsers().stream()
                .filter(applicationUser -> username.equalsIgnoreCase(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getAllApplicationUsers(){

        List<ApplicationUser> applicationUsers = new ArrayList<>();

        ApplicationUser annasmithUser = ApplicationUser.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("password"))
//                .roles(ApplicationUserRole.STUDENT.name()) //ROLE_STUDENT
                .authorities(ApplicationUserRole.STUDENT.getAuthorities())
                .accountNonExpired(true).accountNonLocked(true)
                .enabled(true).credentialsNonExpired(true)
                .build();

        ApplicationUser lindaUser = ApplicationUser.builder()
                .username("linda")
                .password(passwordEncoder.encode("password"))
//                .roles(ApplicationUserRole.ADMIN.name()) //ROLE_ADMIN
                .authorities(ApplicationUserRole.ADMIN.getAuthorities())
                .accountNonExpired(true).accountNonLocked(true)
                .enabled(true).credentialsNonExpired(true)
                .build();

        ApplicationUser tomUser = ApplicationUser.builder()
                .username("tom")
                .password(passwordEncoder.encode("password"))
//                .roles(ApplicationUserRole.ADMINTRAINEE.name()) //ROLE_ADMINTRAINEE
                .authorities(ApplicationUserRole.ADMINTRAINEE.getAuthorities())
                .accountNonExpired(true).accountNonLocked(true)
                .enabled(true).credentialsNonExpired(true)
                .build();

        applicationUsers.add(annasmithUser);
        applicationUsers.add(lindaUser);
        applicationUsers.add(tomUser);

        return applicationUsers;
    }
}
