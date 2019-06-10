package org.levelup.server.chat.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.levelup.server.chat.database.SessionFactoryInitializer;
import org.levelup.server.chat.domain.User;

public class UserRepositoryImpl implements UserRepository {

   private SessionFactory factory;

   public UserRepositoryImpl() {
      factory = SessionFactoryInitializer.getFactory();
   }


    @Override
    public User findByLogin(String line) throws NotFoundException {
        Session session = factory.openSession();
        String[] lineSplit = line.split(" ");
        User user = session.createQuery("from User where login = :login", User.class)
                .setParameter("login", lineSplit[0])
                .getResultList().stream().findFirst().orElseThrow(() -> new NotFoundException());

        if (!user.getPassword().equalsIgnoreCase(lineSplit[1])) throw new NotFoundException();
        session.close();
        return user;

    }
}
