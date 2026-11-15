package io.github.rostikq.task02;

import io.github.rostikq.logger.Logger;

class ViberChannel implements MessageChannel {
    @Override
    public void send(String message) {
        Logger.log("ViberChannel", "Надсилання Viber-повідомлення: \"" + message + "\"");
    }
}
