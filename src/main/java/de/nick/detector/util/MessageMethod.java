package de.nick.detector.util;

/**
 * copyright by Nick 05.11.2017
 */
public class MessageMethod {

    public static String sendMessage(String prefix, String message) {
        final String msg = "§8§l[§6§l"+prefix+"§8§l] §c§l" + message;
        return msg;
    }
}
