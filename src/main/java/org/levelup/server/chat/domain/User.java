package org.levelup.server.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Setter
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @SequenceGenerator(name ="user_id_generator", sequenceName = "user_id_seq", initialValue = 1)
    @GeneratedValue(generator = "user_id_generator", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

   @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE
    })
    private UserDetails details;

    @ManyToMany
    @JoinTable(
            name = "users_in_room",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Collection<Room> rooms;

    @OneToMany(mappedBy = "user")
    private Collection<Message> messages;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
