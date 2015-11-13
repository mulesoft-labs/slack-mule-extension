/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.extensions.client.model.chat.MessageResponse;
import org.mule.extensions.client.model.file.FileUploadResponse;
import org.mule.tck.junit4.ExtensionsFunctionalTestCase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class SlackExtensionTestCase extends ExtensionsFunctionalTestCase {

    @Override
    protected Class<?>[] getAnnotatedExtensionClasses()
    {
        return new Class<?>[] {SlackExtension.class};
    }

    @Override
    protected String getConfigFile()
    {
        return "slack-test.xml";
    }

    @Test
    public void testDummy() throws Exception {
        MuleEvent muleEvent = runFlow("dummy");
        MessageResponse payload = (MessageResponse) muleEvent.getMessage().getPayload();
        assertEquals("Hey!", payload.getMessage().getText());
    }

    @Test
    public void testSendFile() throws Exception {
        String text = "Text as inputStream";
        InputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        MuleEvent muleEvent = runFlow("send-file", stream);
        FileUploadResponse payload = (FileUploadResponse) muleEvent.getMessage().getPayload();
        assertEquals("Text as inputStream", payload.getPreview());
    }


}
