package models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder

public class Contact {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String description;
}
