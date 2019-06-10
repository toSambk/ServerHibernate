package org.levelup.server.chat.command;

import org.levelup.server.chat.domain.Room;
import org.levelup.server.chat.repository.NotFoundException;
import org.levelup.server.chat.repository.RoomRepository;
import org.levelup.server.chat.repository.RoomRepositoryImpl;
import java.util.Collection;

public class GetRoomsCommandExecutor implements CommandExecutor {

    private final RoomRepository roomRepository;

    public GetRoomsCommandExecutor() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute() {
        Collection<Room> rooms = roomRepository.findAll();
        rooms.forEach(x-> System.out.println(x.getName()));
    }

    @Override
    public void execute(String line) throws NotFoundException {

    }

}
