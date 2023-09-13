package com.example.spring5securityapp.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum ApplicationUserRole {

    STUDENT(new HashSet<>(Arrays.asList(ApplicationUserPermission.STUDENT_READ,
             ApplicationUserPermission.COURSE_READ))),
    ADMIN(new HashSet<>(Arrays.asList(ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE, ApplicationUserPermission.COURSE_READ, ApplicationUserPermission.COURSE_WRITE)));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }
}
