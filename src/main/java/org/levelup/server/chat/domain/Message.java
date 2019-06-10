package org.levelup.server.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @SequenceGenerator(name ="message_id_generator", sequenceName = "mes_id_seq", initialValue = 5)
    @GeneratedValue(generator = "message_id_generator", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room curRoom;


}
