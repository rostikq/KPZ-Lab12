package io.github.rostikq.task02;

public abstract class Notification {
    protected MessageChannel channel;

    protected Notification(MessageChannel channel) {
        this.channel = channel;
    }

    public void setChannel(MessageChannel channel) {
        this.channel = channel;
    }

    public abstract void notifyClient(String recipient);
}