/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.api.connection.*;
import org.mule.extension.api.annotation.Alias;
import org.mule.extension.api.annotation.Parameter;
import org.mule.extensions.client.SlackClient;

@Alias("token")
public class SlackConnectionProvider implements ConnectionProvider<SlackExtension, SlackClient> {

    @Parameter public String token;

    @Override
    public SlackClient connect(SlackExtension slackExtension) throws ConnectionException {
        return new SlackClient(token);
    }

    @Override
    public void disconnect(SlackClient slackClient) {
        //Nothing to do
    }

    @Override
    public ConnectionValidationResult validate(SlackClient slackClient) {
        //TODO Improve error message
        return slackClient.isConnected() ?
                ConnectionValidationResult.success() :
                ConnectionValidationResult.failure("Invalid credentials", ConnectionExceptionCode.INCORRECT_CREDENTIALS, null);
    }

    @Override
    public ConnectionHandlingStrategy<SlackClient> getHandlingStrategy(ConnectionHandlingStrategyFactory connectionHandlingStrategyFactory) {
        return connectionHandlingStrategyFactory.cached();
    }
}
