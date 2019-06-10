package org.levelup.server.chat;

import lombok.AllArgsConstructor;
import org.levelup.server.chat.command.CommandParser;

import java.io.*;
import java.net.Socket;

@AllArgsConstructor
public class CommandWorker implements Runnable {

    /*private final BufferedReader console =
            new BufferedReader(new InputStreamReader(System.in));*/
    private final Socket socket;

    private final ChatServer chatServer;

    @Override
    public void run() {

        try (BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter toClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                String line;
                CommandParser commandParser = new CommandParser();
                while (!"stop".equalsIgnoreCase((line = fromClient.readLine() ))) {
                    System.out.println(line);
                    commandParser.executeCommand(line);
                }
                chatServer.stopServer();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
