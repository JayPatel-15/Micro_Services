package com.microService.UserService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  int id;
    private  String name;
    private  String location;
    private  String about;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Rating rating;

}
