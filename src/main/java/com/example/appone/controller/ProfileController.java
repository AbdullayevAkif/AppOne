package com.example.appone.controller;

import com.example.appone.entity.User;
import com.example.appone.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return profileService.getUsers();
    }

    @GetMapping("/get-User/{id}")
    public User getUserById(@PathVariable Long id) {
        return profileService.getUserById(id);
    }

    @PostMapping("/create-User")
  public User createUser(@RequestBody User user) {
        return profileService.createUser(user);
  }

  @PutMapping("/set-User")
  public User updateUser(@RequestParam Long id , @RequestBody User user) {
        return profileService.updateUser(id, user);
  }

  @DeleteMapping("/delete-User")
  public boolean deleteUser( @RequestParam Long id) {
        return profileService.deleteUser(id);
  }

}
