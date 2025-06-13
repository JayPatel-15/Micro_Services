package com.microService.UserService.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Transient
    private List<Rating> ratings;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Transient
    private List<Hotel> hotel;

}