/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.extensions;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.capability.Xml;
import org.mule.runtime.extension.api.annotation.connector.Providers;

@Extension(name = "Slack Connector", description = "Connector which connects to the most popular team communication tool")
@Operations(SlackOperations.class)
@Providers(SlackConnectionProvider.class)
@Sources({SlackRetrieveEventsSource.class})
@Xml(namespace = "slack")
public class SlackExtension {

}
