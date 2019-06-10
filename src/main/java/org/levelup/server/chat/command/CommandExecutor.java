package org.levelup.server.chat.command;

import org.levelup.server.chat.repository.NotFoundException;

public interface CommandExecutor {

    void execute();

    void execute(String line) throws NotFoundException;

}
