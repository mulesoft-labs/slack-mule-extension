package org.mule.extensions;


import org.mule.extensions.client.SlackClient;
import org.mule.extensions.client.rtm.ConfigurableHandler;
import org.mule.extensions.client.rtm.filter.EventFilter;
import org.mule.extensions.client.rtm.filter.EventNotifier;
import org.mule.extensions.client.rtm.filter.MessagesNotifier;
import org.mule.extensions.client.rtm.filter.OnlyTypeNotifier;
import org.mule.extensions.client.rtm.filter.SelfEventsFilter;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.metadata.MetadataScope;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.runtime.source.Source;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.DeploymentException;

@Alias("RetrieveEvents")
@MetadataScope(outputResolver = RetrieveEventsOutputResolver.class)
public class SlackRetrieveEventsSource extends Source<Map, Serializable>
{

    public static final String USER_TYPING_EVENT = "user_typing";
    private static final String IM_CREATED = "im_created";
    private static final String FILE_CREATED = "file_created";
    private static final String FILE_SHARED = "file_shared";
    private static final String FILE_PUBLIC = "file_public";

    @Connection
    private SlackClient slackClient;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean messages;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean userTyping;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean directMessages;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean onlyNewMessages;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean ignoreSelfEvents;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean imCreated;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean fileCreated;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean fileShared;

    @Parameter
    @Optional(defaultValue = "false")
    Boolean filePublic;

    @Parameter
    @Optional
    String filterClassName;

    @Parameter
    @Optional
    String notifierClassName;

    @Override
    public void start() {

        List<EventNotifier> observerList = new ArrayList<>();
        List<EventFilter> eventFilterList = new ArrayList<>();

        if (messages) {
            observerList.add(new MessagesNotifier(directMessages, onlyNewMessages));
        }

        if (userTyping) {
            observerList.add(new OnlyTypeNotifier(USER_TYPING_EVENT));
        }

        if (imCreated) {
            observerList.add(new OnlyTypeNotifier(IM_CREATED));
        }

        if (fileCreated) {
            observerList.add(new OnlyTypeNotifier(FILE_CREATED));
        }

        if (fileShared) {
            observerList.add(new OnlyTypeNotifier(FILE_SHARED));
        }

        if (filePublic) {
            observerList.add(new OnlyTypeNotifier(FILE_PUBLIC));
        }

        //        if (StringUtils.isNotEmpty(filterClassName)) {
        //            eventFilterList.add(getFilterInstance(filterClassName));
        //        }
        //
        //        if (StringUtils.isNotEmpty(notifierClassName)) {
        //            observerList.add(getNotifierInstance(notifierClassName));
        //        }
        //
        if (ignoreSelfEvents) {
            eventFilterList.add(new SelfEventsFilter(slackClient.getSelfId()));
        }

        try {
            //TODO Review duplicated parameter
            slackClient.startRealTimeCommunication(sourceContext, new ConfigurableHandler(sourceContext, observerList, eventFilterList));
        } catch (DeploymentException | InterruptedException | IOException e) {
            throw new RuntimeException("Error starting RTM communication", e);
        }
    }

    @Override
    public void stop() {
        //TODO Review what to do here
        //Don't stop me now...
    }

}
