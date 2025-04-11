package com.example.appone.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    Profile profile;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL , fetch =  FetchType.EAGER)
    List<Post> posts;


}
