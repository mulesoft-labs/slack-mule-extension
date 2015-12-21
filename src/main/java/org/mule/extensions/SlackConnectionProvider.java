/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.api.config.PoolingProfile;
import org.mule.api.connection.ConnectionException;
import org.mule.api.connection.ConnectionHandlingStrategy;
import org.mule.api.connection.ConnectionHandlingStrategyFactory;
import org.mule.api.connection.ConnectionProvider;
import org.mule.extension.annotation.api.Parameter;
import org.mule.extensions.client.SlackClient;

public class SlackConnectionProvider implements ConnectionProvider<SlackConfig, SlackClient> {

    @Override public SlackClient connect(SlackConfig slackConfig) throws ConnectionException {
        return slackConfig.getSlackClient();
    }

    @Override public void disconnect(SlackClient slackClient) {
    }

    @Override public ConnectionHandlingStrategy<SlackClient> getHandlingStrategy(ConnectionHandlingStrategyFactory connectionHandlingStrategyFactory) {
            return connectionHandlingStrategyFactory.supportsPooling(new PoolingProfile());
    }
}
