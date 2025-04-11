package com.example.appone.service;


import com.example.appone.entity.Post;
import com.example.appone.entity.User;
import com.example.appone.expection.UserNotFoundException;
import com.example.appone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService {

    private final UserRepository userRepository;

    public ProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
         return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
    }

    public User createUser(User user) {
        if(user.getPosts() != null) {
           user.getPosts().forEach(post -> {post.setUser(user);});
        }
        return userRepository.save(user);
    }

     public User updateUser(Long id, User newUser) {
        User user = getUserById(id);

        user.setName(newUser.getName());
        user.setProfile(newUser.getProfile());

      if(newUser.getPosts() != null) {
          for(Post post : newUser.getPosts()) {
              post.setUser(user);
              user.getPosts().add(post);
          }

      }
         return userRepository.save(user);
     }


     public boolean deleteUser(Long id) {
        User user = getUserById(id);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }

        userRepository.deleteById(id);
        return true;
     }
}
