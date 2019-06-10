package org.levelup.server.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_info")
public class UserDetails implements Serializable {

    @Id
    @OneToOne
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "last_login")
    private String lastLogin;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;


}
