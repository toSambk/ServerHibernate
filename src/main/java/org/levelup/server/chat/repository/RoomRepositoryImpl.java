package org.levelup.server.chat.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.server.chat.database.SessionFactoryInitializer;
import org.levelup.server.chat.domain.Room;

import java.util.Collection;
import java.util.List;


public class RoomRepositoryImpl implements RoomRepository {

    private SessionFactory factory;

    public RoomRepositoryImpl(){
        this.factory = SessionFactoryInitializer.getFactory();
    }

    @Override
    public Room createRoom(String name) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Room room = new Room(name);
        session.save(room);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public Collection<Room> findAll() {
        Session session = factory.openSession();
        List<Room> from_room = session.createQuery("from Room", Room.class).getResultList();
        session.close();
        return from_room;
    }
}
