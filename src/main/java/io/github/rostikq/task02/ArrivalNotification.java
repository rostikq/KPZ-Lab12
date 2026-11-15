package io.github.rostikq.task02;

class ArrivalNotification extends Notification {
    public ArrivalNotification(MessageChannel channel) { super(channel); }

    @Override
    public void notifyClient(String recipient) {
        channel.send("Шановний клієнте (" + recipient + "), ваше відправлення прибуло у відділення!");
    }
}
