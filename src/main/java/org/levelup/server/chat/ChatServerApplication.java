package org.levelup.server.chat;

import java.io.IOException;

public class ChatServerApplication {

    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(7878);
        chatServer.startServer();
    }

}
