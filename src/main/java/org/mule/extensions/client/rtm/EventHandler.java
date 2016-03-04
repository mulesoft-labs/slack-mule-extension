package org.mule.extensions.client.rtm;

public interface EventHandler {
    void onMessage(String message);
}
