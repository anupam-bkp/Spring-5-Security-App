package com.example.spring5securityapp.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {

   /* STUDENT(new HashSet<>(Arrays.asList(ApplicationUserPermission.STUDENT_READ,
             ApplicationUserPermission.COURSE_READ))),*/
    STUDENT(Collections.emptySet()),
    ADMIN(new HashSet<>(Arrays.asList(ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE, ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE))),
    ADMINTRAINEE(new HashSet<>(Arrays.asList(ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.COURSE_READ)));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){

        Set<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }


}
