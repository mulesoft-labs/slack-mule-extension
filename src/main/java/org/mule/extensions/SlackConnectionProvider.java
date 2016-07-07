/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.extensions.client.SlackClient;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionExceptionCode;
import org.mule.runtime.api.connection.ConnectionHandlingStrategy;
import org.mule.runtime.api.connection.ConnectionHandlingStrategyFactory;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Parameter;

@Alias("token")
public class SlackConnectionProvider implements ConnectionProvider<SlackClient>
{

    @Parameter
    public String token;

    @Override
    public SlackClient connect() throws ConnectionException
    {
        return new SlackClient(token);
    }

    @Override
    public void disconnect(SlackClient slackClient)
    {
        //Nothing to do
    }

    @Override
    public ConnectionValidationResult validate(SlackClient slackClient)
    {
        //TODO Improve error message
        return slackClient.isConnected() ?
               ConnectionValidationResult.success() :
               ConnectionValidationResult.failure("Invalid credentials", ConnectionExceptionCode.INCORRECT_CREDENTIALS, null);
    }

    @Override
    public ConnectionHandlingStrategy<SlackClient> getHandlingStrategy(ConnectionHandlingStrategyFactory connectionHandlingStrategyFactory)
    {
        return connectionHandlingStrategyFactory.cached();
    }

}
