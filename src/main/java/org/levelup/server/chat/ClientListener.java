package org.levelup.server.chat;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@RequiredArgsConstructor
public class ClientListener implements Runnable {

    private volatile boolean running = true;

    private final ServerSocket server;

    private final ChatServer chatServer;

    @Override
    public void run() {
        while (running) {
            try {
                Socket socket = server.accept();
                new Thread(new CommandWorker(socket, chatServer)).start();
            } catch (IOException e) {
                System.out.println("Server stopped...");
            }
        }
    }

    public void shutDown() {
        running = false;
        try {
            server.close();
        } catch (IOException e) {
            System.out.println("Server stopped...");
        }
    }
}
