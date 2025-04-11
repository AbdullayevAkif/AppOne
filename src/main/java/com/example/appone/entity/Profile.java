package com.example.appone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String bio;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    User user;

}
