/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;


import org.mule.extension.annotations.Configuration;
import org.mule.extension.annotations.Parameter;
import org.mule.extensions.client.SlackClient;

@Configuration(name = "Token")
public class SlackTokenConfig {

    @Parameter
    private String token;

    private SlackClient slackClient;

    public SlackClient getSlackClient(){
        return new SlackClient(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
