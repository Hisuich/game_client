package ua.game.client;

import static ua.game.client.Constants.CLIENT_VERSION;
import static ua.game.client.Constants.DELIMITER;

public class GameActionRequest {

    public String token;
    public int attack;
    public int defence;
    public int dodge;
    public int recovery;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("GAME");
        builder.append(DELIMITER);
        builder.append(CLIENT_VERSION);
        builder.append("\n");
        builder.append("COMMAND");
        builder.append(DELIMITER);
        builder.append("ACTION");
        builder.append("\n");
        builder.append("ATTACK");
        builder.append(DELIMITER);
        builder.append(attack);
        builder.append("\n");
        builder.append("DEFENCE");
        builder.append(DELIMITER);
        builder.append(defence);
        builder.append("\n");
        builder.append("DODGE");
        builder.append(DELIMITER);
        builder.append(dodge);
        builder.append("\n");
        builder.append("RECOVERY");
        builder.append(DELIMITER);
        builder.append(recovery);
        builder.append("\n");

        return builder.toString();
    }
}
