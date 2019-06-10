package org.levelup.server.chat.command;

import org.levelup.server.chat.repository.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    private Map<String, CommandExecutor> executors;

    private Map<String, CommandExecutor> clientOnlyExecutors;

    {
        executors = new HashMap<>();
        executors.put("rooms", new GetRoomsCommandExecutor());
        executors.put("create_room", new CreateRoomCommandExecutor());
        executors.put("find_by_login", new FindByLogin());

        clientOnlyExecutors = new HashMap<>();
        clientOnlyExecutors.put("rooms", new GetRoomsCommandExecutor());
        clientOnlyExecutors.put("find_by_login", new FindByLogin());
    }

    public void executeCommand(String line) {

        String[] lineSplit = line.split(" ");
        CommandExecutor executor = executors.get("find_by_login");
        try {
            executor.execute(lineSplit[0] +" "+ lineSplit[1]);

            if (lineSplit[0].equalsIgnoreCase("admin")) {
                executor = executors.get(lineSplit[2]);
                if (executor!=null){

                    if (lineSplit.length < 4) {
                        executor.execute();
                    } else {
                        executor.execute(lineSplit[3]);
                    }
                } else {
                    System.out.println("Вы ввели неверную команду.");
                }
            } else {
                executor = clientOnlyExecutors.get(lineSplit[2]);
                if (executor!=null){
                    executor.execute();
                } else {
                    System.out.println("Вы ввели неверную команду, либо отсутствует доступ.");
                }
            }
        } catch (NotFoundException e) {
            System.out.println("Пользователя с таким логином не существует либо неверный пароль");
        }

    }

}
