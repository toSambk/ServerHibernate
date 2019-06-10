package org.levelup.server.chat.command;

import org.levelup.server.chat.domain.Room;
import org.levelup.server.chat.repository.RoomRepository;
import org.levelup.server.chat.repository.RoomRepositoryImpl;

public class CreateRoomCommandExecutor implements CommandExecutor {

    private final RoomRepository roomRepository;

    public CreateRoomCommandExecutor() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String name) {
        Room cats = roomRepository.createRoom(name);
    }
}
