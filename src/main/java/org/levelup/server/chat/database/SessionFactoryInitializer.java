package org.levelup.server.chat.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.levelup.server.chat.domain.Message;
import org.levelup.server.chat.domain.Room;
import org.levelup.server.chat.domain.User;
import org.levelup.server.chat.domain.UserDetails;

import java.util.Properties;

public class SessionFactoryInitializer {

    private static SessionFactory factory;

    static {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        dbProperties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/coto-chat");
        dbProperties.setProperty("hibernate.connection.username", "postgres");
        dbProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        dbProperties.setProperty("hibernate.connection.password", "root");
        dbProperties.setProperty("hbm2ddl.auto", "create");
        dbProperties.setProperty("show_sql", "true");
        dbProperties.setProperty("format_sql", "true");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(dbProperties)
                .build();
        factory = new Configuration()
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Message.class)
                .buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
