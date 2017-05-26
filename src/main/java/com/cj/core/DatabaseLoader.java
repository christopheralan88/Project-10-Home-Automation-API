package com.cj.core;


import com.cj.user.User;
import com.cj.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final UserRepository users;

    //injects whatever class we have implementing the UserRepository interface
    @Autowired
    public DatabaseLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] roles = {"role1", "role2"};
        User user = new User("Chris", roles, "123");
        users.save(user);
    }
}
