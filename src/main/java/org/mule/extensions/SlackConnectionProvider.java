/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.mule.api.config.PoolingProfile;
import org.mule.api.connection.*;
import org.mule.extension.annotation.api.Alias;
import org.mule.extension.annotation.api.Parameter;
import org.mule.extensions.client.SlackClient;

@Alias("cached")
public class SlackConnectionProvider implements ConnectionProvider<SlackConfig, SlackClient> {

    @Parameter
    public String someValue;

    @Override public SlackClient connect(SlackConfig slackConfig) throws ConnectionException {
        return slackConfig.getSlackClient();
    }

    @Override public void disconnect(SlackClient slackClient) {
    }

    @Override
    public ConnectionValidationResult validate(SlackClient slackClient) {
        return ConnectionValidationResult.success();
    }

    @Override public ConnectionHandlingStrategy<SlackClient> getHandlingStrategy(ConnectionHandlingStrategyFactory connectionHandlingStrategyFactory) {
            return connectionHandlingStrategyFactory.cached();
    }
}
