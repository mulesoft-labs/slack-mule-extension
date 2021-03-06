/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.extensions.client;

/**
 * Created by estebanwasinger on 12/5/14.
 */
public class Operations {

    private Operations() {
    }

    public static final String USER_INFO = "users.info";
    public static final String USER_LIST = "users.list";
    public static final String CHANNELS_LIST = "channels.list";
    public static final String CHANNELS_HISTORY = "channels.history";
    public static final String CHANNELS_INFO = "channels.info";
    public static final String CHANNELS_CREATE = "channels.create";
    public static final String CHANNELS_RENAME = "channels.rename";
    public static final String CHANNELS_JOIN = "channels.join";
    public static final String CHANNELS_LEAVE = "channels.leave";
    public static final String CHANNELS_SETPURPOSE = "channels.setPurpose";
    public static final String CHANNELS_SETTOPIC= "channels.setTopic";
    public static final String CHANNELS_KICK= "channels.kick";
    public static final String CHANNELS_INVITE= "channels.invite";
    public static final String CHANNELS_MARK= "channels.mark";
    public static final String CHANNELS_UNARCHIVE= "channels.unarchive";
    public static final String CHANNELS_ARCHIVE= "channels.archive";
    public static final String AUTH_TEST = "auth.test";
    public static final String CHAT_POSTMESSAGE = "chat.postMessage";
    public static final String CHAT_DELETE = "chat.delete";
    public static final String CHAT_UPDATE = "chat.update";
    public static final String IM_OPEN = "im.open";
    public static final String IM_LIST = "im.list";
    public static final String IM_MARK = "im.mark";
    public static final String IM_CLOSE = "im.close";
    public static final String IM_HISTORY = "im.history";
    public static final String GROUPS_HISTORY = "groups.history";
    public static final String GROUPS_LIST = "groups.list";
    public static final String GROUPS_CREATE = "groups.create";
    public static final String GROUPS_LEAVE = "groups.leave";
    public static final String GROUPS_ARCHIVE = "groups.archive";
    public static final String GROUPS_OPEN = "groups.open";
    public static final String GROUPS_SETPORPUSE = "groups.setPurpose";
    public static final String GROUPS_SETTOPIC= "groups.setTopic";
    public static final String GROUPS_RENAME= "groups.rename";
    public static final String GROUPS_MARK= "groups.mark";
    public static final String GROUPS_KICK= "groups.kick";
    public static final String GROUPS_INVITE= "groups.invite";
    public static final String GROUPS_CLOSE= "groups.close";
    public static final String GROUPS_UNARCHIVE= "groups.unarchive";
    public static final String GROUPS_INFO = "groups.info";
    public static final String FILES_UPLOAD = "files.upload";
    public static final String SEARCH_MESSAGES = "search.messages";
    public static final String RTM_START = "rtm.start";
}
