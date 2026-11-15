package io.github.rostikq.task02;

import io.github.rostikq.logger.Logger;

public class TelegramChannel implements MessageChannel {
    @Override
    public void send(String message) {
        Logger.log("TelegramChannel", "Надсилання Telegram-повідомлення: \"" + message + "\"");
    }
}