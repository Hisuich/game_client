package ua.game.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static ua.game.client.Constants.SERVER_ADDRESS;
import static ua.game.client.Constants.SERVER_PORT;

public class Client {

    public void init() throws IOException {
        while (true) {

            GameActionRequest request = promptAction();

            if (request == null) {
                continue;
            }

            System.out.println("Opening connection to the server...");
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            OutputStream out = socket.getOutputStream();
            out.write(request.toString().getBytes());
            socket.shutdownOutput();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String responseLine = in.readLine();
                if (responseLine == null) {
                    break;
                }
                System.out.println(responseLine);
            }

            socket.shutdownInput();
        }
    }

    public GameActionRequest promptAction() {
        GameActionRequest gameActionRequest = new GameActionRequest();

        System.out.println("Input command");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] str = sc.nextLine().split(" ");
            if (str.length <= 1 ) {
                if("send".equals(str[0])) {
                    System.out.println("Sending request to server...");
                    return gameActionRequest;
                }
                System.out.println("Please input command");
            }
            try {
                Integer.parseInt(str[1]);
            } catch (NumberFormatException e) {
                System.out.println("Not corrent input");
            }
            int percent = Integer.parseInt(str[1]);

            switch(str[0]) {

                case "attack":
                    gameActionRequest.attack = percent;
                    break;
                case "defence":
                    gameActionRequest.defence = percent;
                    break;
                case "dodge":
                    gameActionRequest.dodge = percent;
                    break;
                case "recovery":
                    gameActionRequest.recovery = percent;
                    break;
                default:
                    System.out.println("Not correct command");
                    break;
            }
        }
    }
}
