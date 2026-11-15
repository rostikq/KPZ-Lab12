package io.github.rostikq.task02;

class PaymentNotification extends Notification {
    public PaymentNotification(MessageChannel channel) { super(channel); }

    @Override
    public void notifyClient(String recipient) {
        channel.send("Шановний клієнте (" + recipient + "), необхідно здійснити оплату послуг доставки.");
    }
}