package io.indreams.ecommerceuserinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = false)
    private String contactNumber;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String roles;

}
