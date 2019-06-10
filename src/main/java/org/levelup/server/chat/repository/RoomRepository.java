package org.levelup.server.chat.repository;

import org.levelup.server.chat.domain.Room;

import java.util.Collection;

public interface RoomRepository {

    Room createRoom(String name);

    Collection<Room> findAll();

}
