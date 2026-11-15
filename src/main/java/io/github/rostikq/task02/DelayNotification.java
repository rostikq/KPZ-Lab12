package io.github.rostikq.task02;

public class DelayNotification extends Notification {
    public DelayNotification(MessageChannel channel) { super(channel); }

    @Override
    public void notifyClient(String recipient) {
        channel.send("Шановний клієнте (" + recipient + "), доставка вашого відправлення затримується.");
    }
}