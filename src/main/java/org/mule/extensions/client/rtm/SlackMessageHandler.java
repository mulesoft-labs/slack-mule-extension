package org.mule.extensions.client.rtm;

import org.glassfish.tyrus.client.ClientManager;
import org.glassfish.tyrus.client.ClientProperties;
import org.mule.runtime.extension.api.runtime.source.SourceContext;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

public class SlackMessageHandler implements MessageHandler.Whole<String> {

    public static final String TYPE_PONG_REPLY_TO_MESSAGE = "{\"type\":\"pong\",\"reply_to\"";
    public static final String TYPE_HELLO_MESSAGE = "{\"type\":\"hello\"})";
    public static final String TYPE_PING_ID_MESSAGE = "{\"type\":\"ping\",\"id\":";
    private String webSocketUrl;
    private Session websocketSession;
    private long lastPingSent = 0;
    private volatile long lastPingAck = 0;
    private boolean reconnectOnDisconnection = true;
    private long messageId = 0;
    public EventHandler messageHandler;

    public SlackMessageHandler(String webSocketUrl) {
        this.webSocketUrl = webSocketUrl;
    }

    public void connect(SourceContext sourceContext) throws IOException, DeploymentException, InterruptedException {
        ClientManager client = ClientManager.createClient();
        client.getProperties().put(ClientProperties.LOG_HTTP_UPGRADE, true);
        final MessageHandler handler = this;
        websocketSession = client.connectToServer(new Endpoint() {

            @Override
            public void onOpen(Session session, EndpointConfig config) {
                session.addMessageHandler(handler);
            }

        }, URI.create(webSocketUrl));
        while (true) {
            try {
                if (lastPingSent != lastPingAck) {
                    // disconnection happened
                    websocketSession.close();
                    lastPingSent = 0;
                    lastPingAck = 0;
                    if (reconnectOnDisconnection) {
                        connect(sourceContext);
                        continue;
                    }
                } else {
                    lastPingSent = getNextMessageId();
                    websocketSession.getBasicRemote().sendText(TYPE_PING_ID_MESSAGE + lastPingSent + "}");
                }
                Thread.sleep(20000);

            } catch (Exception e) {
                //TODO - This maybe should be closed in the stop() of the Source
                websocketSession.close();
                sourceContext.getExceptionCallback().onException(e);
                break;
            }
        }
    }

    public void onMessage(String message) {
        if (message.contains(TYPE_PONG_REPLY_TO_MESSAGE)) {
            int rightBracketIdx = message.indexOf('}');
            String toParse = message.substring(26, rightBracketIdx);
            lastPingAck = Integer.parseInt(toParse);
            return;
        }
        if (!message.contains(TYPE_HELLO_MESSAGE)) {
            messageHandler.onMessage(message);
        }
    }

    private synchronized long getNextMessageId() {
        return messageId++;
    }

    public void disconnect() throws IOException {
        websocketSession.close();
    }

}
