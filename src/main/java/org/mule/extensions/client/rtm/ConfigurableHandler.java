package org.mule.extensions.client.rtm;

import com.google.gson.Gson;
import org.mule.api.metadata.DataType;
import org.mule.api.temporary.MuleMessage;
import org.mule.extension.api.runtime.source.SourceContext;
import org.mule.extensions.client.rtm.filter.EventFilter;
import org.mule.extensions.client.rtm.filter.EventNotifier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurableHandler implements EventHandler {

    private final SourceContext<Map, Serializable> sourceContext;

    Gson gson = new Gson();
    Class<? extends Map> stringStringMap = HashMap.class;
    private List<EventNotifier> observerList;
    private List<EventFilter> eventFilterList;

    public ConfigurableHandler(SourceContext<Map, Serializable> sourceContext, List<EventNotifier> eventNotifierList, List<EventFilter> eventFilterList) {
        this.sourceContext = sourceContext;
        this.observerList = eventNotifierList;
        this.eventFilterList = eventFilterList;
    }

    public void onMessage(String message) {
        Map messageMap = gson.fromJson(message, stringStringMap);

        if (shouldBeAccepted(messageMap, eventFilterList)) {
            if (shouldBeSent(messageMap, observerList)) {
                try {
                    //TODO Check horrible cast
                    sourceContext.getMessageHandler().handle(makeMessage(messageMap));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean shouldBeAccepted(Map<String, Object> message, List<EventFilter> filterList) {
        for (EventFilter eventFilter : filterList) {
            if (!eventFilter.shouldAccept(message)) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldBeSent(Map<String, Object> message, List<EventNotifier> observerList) {
        for (EventNotifier eventNotifier : observerList) {
            if (eventNotifier.shouldSend(message)) {
                return true;
            }
        }
        return false;
    }

    //TODO MALIIIIISIMO
    private MuleMessage<Map, Serializable> makeMessage(Map value) {
        return new MuleMessage<Map, Serializable>() {

            @Override
            public Map getPayload() {
                return value;
            }

            @Override
            public Serializable getAttributes() {
                return null;
            }

            @Override
            public DataType<?> getDataType() {
                return null;
            }
        };
    }

}
