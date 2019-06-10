package org.levelup.server.chat.repository;

import org.levelup.server.chat.domain.User;

public interface UserRepository {

    User findByLogin(String login) throws NotFoundException;
}
