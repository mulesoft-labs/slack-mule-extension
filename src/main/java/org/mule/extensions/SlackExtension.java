/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.extensions;

import org.mule.extension.annotations.Configurations;
import org.mule.extension.annotations.Extension;
import org.mule.extension.annotations.Operations;
import org.mule.extension.annotations.capability.Xml;

@Extension(name = "SlackConnector", description = "Slack Connector", version = "1.0")
@Operations(SlackOperations.class)
@Configurations({SlackTokenConfig.class})
@Xml(schemaLocation = "http://www.mulesoft.org/schema/mule/slack", namespace = "slack", schemaVersion = "3.7")
public class SlackExtension {

}
