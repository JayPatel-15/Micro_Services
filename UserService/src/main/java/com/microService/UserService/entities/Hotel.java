package com.microService.UserService.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {

    private  int id;
    private  String name;
    private  String location;
    private  String about;

    private Rating rating;

}
