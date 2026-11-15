package io.github.rostikq.task02;
import io.github.rostikq.logger.Logger;

public class SmsChannel implements MessageChannel {
    @Override
    public void send(String message) {
        Logger.log("SmsChannel", "Надсилання SMS: \"" + message + "\"");
    }
}