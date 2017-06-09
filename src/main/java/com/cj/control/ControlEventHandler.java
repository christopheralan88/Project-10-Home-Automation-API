package com.cj.control;

import com.cj.user.User;
import com.cj.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
    private final UserRepository users;

    @Autowired
    public ControlEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeSave
    public void addUserToControlLastModifiedFieldWhenUpdating(Control control) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(username);
        control.setLastModifiedBy(user);
    }
}
