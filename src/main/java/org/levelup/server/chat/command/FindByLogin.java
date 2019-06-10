package org.levelup.server.chat.command;

import org.levelup.server.chat.domain.User;
import org.levelup.server.chat.repository.NotFoundException;
import org.levelup.server.chat.repository.RoomRepository;
import org.levelup.server.chat.repository.UserRepository;
import org.levelup.server.chat.repository.UserRepositoryImpl;

public class FindByLogin implements CommandExecutor {

    private final UserRepository userRepository;

    public FindByLogin() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String line) throws NotFoundException {
            User user = userRepository.findByLogin(line);

    }
}
