/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.extensions.client.SlackClient;
import org.mule.extensions.client.exceptions.UserNotFoundException;
import org.mule.extensions.client.model.User;
import org.mule.extensions.client.model.channel.Channel;
import org.mule.extensions.client.model.chat.Message;
import org.mule.extensions.client.model.chat.MessageResponse;
import org.mule.extensions.client.model.file.FileUploadResponse;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;

import java.io.InputStream;
import java.util.List;

public class SlackOperations {

    public MessageResponse sendMessage(@Connection SlackClient client, String message, String channelId, @Optional String username, @Optional String iconUrl, @Optional(defaultValue = "false") Boolean asUser) {
        return client.sendMessage(message, channelId, username, iconUrl, asUser);
    }

    public User getUserInfo(@Connection SlackClient client, String id) {
        return client.getUserInfo(id);
    }

    public User getUserInfoByName(@Connection SlackClient client, String username) throws UserNotFoundException {
        return client.getUserInfoByName(username);
    }

    public User getUserInfoByNames(@Connection SlackClient client, String username) throws UserNotFoundException {
        return client.getUserInfoByName(username);
    }

    public List<User> getUserList(@Connection SlackClient client) {
        return client.getUserList();
    }

    public List<Channel> getChannelList(@Connection SlackClient client) {
        return client.getChannelList();
    }

    public List<Message> getChannelHistory(@Connection SlackClient client, String channelId, @Optional String latestTimestamp, @Optional String oldestTimestamp,
            String mountOfMessages) {
        return client.getChannelHistory(channelId, latestTimestamp, oldestTimestamp, mountOfMessages);
    }

    public Channel getChannelInfo(@Connection SlackClient client, String channelId) {
        return client.getChannelById(channelId);
    }

    public Channel getChannelByName(@Connection SlackClient client, String channelName) {
        return client.getChannelByName(channelName);
    }

    public Channel createChannel(@Connection SlackClient client, String channelName) {
        return client.createChannel(channelName);
    }

    public Channel renameChannel(@Connection SlackClient client, String channelId, String channelName) {
        return client.renameChannel(channelId, channelName);
    }

    public Channel joinChannel(@Connection SlackClient client, String channelName) {
        return client.joinChannel(channelName);
    }

    public FileUploadResponse sendFile(@Connection SlackClient client, String channelId, @Optional String fileName, @Optional String fileType, @Optional String title,
            @Optional String initialComment, InputStream file) {
        return client.sendFile(channelId, fileName, fileType, title, initialComment, file);
    }

}
