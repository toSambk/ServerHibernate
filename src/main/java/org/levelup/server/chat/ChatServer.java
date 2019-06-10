package org.levelup.server.chat;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;

@AllArgsConstructor
public class ChatServer {

    private final int port;
    private ClientListener listener;

    public ChatServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(port);
        listener = new ClientListener(server, this);
        new Thread(listener).start();
        //new Thread(new CommandWorker(this)).start();
    }

    public void stopServer() {
        listener.shutDown();
    }



}
