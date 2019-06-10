package org.levelup.server.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "rooms")
public class Room implements Serializable {


    @Id
    @SequenceGenerator(name = "room_id_generator", sequenceName = "room_id_seq", initialValue = 15)
    @GeneratedValue(generator = "room_id_generator", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(mappedBy = "rooms")
    private Collection<User> usersInRoom;

    @OneToMany(mappedBy = "curRoom")
    private Collection<Message> messagesInRoom;

    public Room(String name) {
        this.name = name;
    }






}
