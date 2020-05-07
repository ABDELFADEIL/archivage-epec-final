package org.simplon.epec.archivage.exposition.user.rest;

import org.simplon.epec.archivage.application.user.UserService;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;



    @PostMapping("/create-user")
    public User createUser(@RequestBody(required = true) User user, @RequestParam(name="rolename", required = true) String rolename) {
        return userService.CreateUser(user, rolename);
    }

    @PutMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/send-password")
    public void resendPassword(@RequestParam(name="rolename") String email)  {
        userService.resendPassword(email);

    }


}
