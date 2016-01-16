/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.extensions;

import org.mule.extension.annotation.api.Configurations;
import org.mule.extension.annotation.api.Extension;
import org.mule.extension.annotation.api.Operations;
import org.mule.extension.annotation.api.capability.Xml;
import org.mule.extension.annotation.api.connector.Providers;

@Extension(name = "Slack Connector", description = "Connector which connects to the most popular team communication tool")
@Operations(SlackOperations.class)
@Providers({SlackConnectionProvider.class,SlackPooledConnectionProvider.class})
@Configurations({SlackTokenConfig.class})
@Xml(schemaLocation = "http://www.mulesoft.org/schema/mule/slack", namespace = "slack", schemaVersion = "3.7")
public class SlackExtension {

}
