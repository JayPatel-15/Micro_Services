package com.microService.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "User_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;

    @Column(name = "User_name")
    private  String name;

    @Column(name = "Email")
    private  String email;

    @Column(name = "About")
    private  String about;

    @Transient
    private Rating ratings;

    @Transient
    private Hotel hotel;

}