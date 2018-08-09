package ua.game;

import ua.game.client.Client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new Client().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
