package io.github.rostikq.task02;

import io.github.rostikq.logger.Logger;

class EmailChannel implements MessageChannel {
    @Override
    public void send(String message) {
        Logger.log("EmailChannel", "Надсилання Email: \"" + message + "\"");
    }
}