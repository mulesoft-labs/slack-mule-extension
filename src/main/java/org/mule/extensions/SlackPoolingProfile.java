/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

public class SlackPoolingProfile extends org.mule.api.config.PoolingProfile {

    public static final int MAX_ACTIVE = 2;

    public SlackPoolingProfile()
    {
        super(MAX_ACTIVE, MAX_ACTIVE, DEFAULT_MAX_POOL_WAIT, WHEN_EXHAUSTED_WAIT, INITIALISE_NONE);
    }
}
