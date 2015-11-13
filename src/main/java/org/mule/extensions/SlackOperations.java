/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.extension.annotations.Operation;
import org.mule.extension.annotations.param.Optional;
import org.mule.extension.annotations.param.UseConfig;
import org.mule.extensions.client.exceptions.UserNotFoundException;
import org.mule.extensions.client.model.User;
import org.mule.extensions.client.model.channel.Channel;
import org.mule.extensions.client.model.chat.Message;
import org.mule.extensions.client.model.chat.MessageResponse;
import org.mule.extensions.client.model.file.FileUploadResponse;

import java.io.InputStream;
import java.util.List;

public class SlackOperations {

    @Operation
    public MessageResponse sendMessage(@UseConfig SlackTokenConfig config, String message, String channelId, String username, String iconUrl, Boolean asUser) {
        return config.getSlackClient().sendMessage(message, channelId, username, iconUrl, asUser);
    }

    @Operation
    public User getUserInfo(@UseConfig SlackTokenConfig config, String id) {
        return config.getSlackClient().getUserInfo(id);
    }

    @Operation
    public User getUserInfoByName(@UseConfig SlackTokenConfig config, String username) throws UserNotFoundException {
        return config.getSlackClient().getUserInfoByName(username);
    }

    @Operation
    public List<User> getUserList(@UseConfig SlackTokenConfig config) {
        return config.getSlackClient().getUserList();
    }

    @Operation
    public List<Channel> getChannelList(@UseConfig SlackTokenConfig config) {
        return config.getSlackClient().getChannelList();
    }

    @Operation
    public List<Message> getChannelHistory(@UseConfig SlackTokenConfig config, String channelId, @Optional String latestTimestamp, @Optional String oldestTimestamp, String mountOfMessages) {
        return config.getSlackClient().getChannelHistory(channelId, latestTimestamp, oldestTimestamp, mountOfMessages);
    }

    @Operation
    public Channel getChannelInfo(@UseConfig SlackTokenConfig config, String channelId) {
        return config.getSlackClient().getChannelById(channelId);
    }


    @Operation
    public Channel getChannelByName(@UseConfig SlackTokenConfig config, String channelName) {
        return config.getSlackClient().getChannelByName(channelName);
    }

    @Operation
    public Channel createChannel(@UseConfig SlackTokenConfig config, String channelName) {
        return config.getSlackClient().createChannel(channelName);
    }

    @Operation
    public Channel renameChannel(@UseConfig SlackTokenConfig config, String channelId, String channelName) {
        return config.getSlackClient().renameChannel(channelId, channelName);
    }

    @Operation
    public Channel joinChannel(@UseConfig SlackTokenConfig config, String channelName) {
        return config.getSlackClient().joinChannel(channelName);
    }

    @Operation
    public FileUploadResponse sendFile(@UseConfig SlackTokenConfig config, String channelId, @Optional String fileName, @Optional String fileType, @Optional String title, @Optional String initialComment, InputStream file) {
        return config.getSlackClient().sendFile(channelId, fileName, fileType, title, initialComment, file);
    }


}
