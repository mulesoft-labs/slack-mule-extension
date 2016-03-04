/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.extensions.client.model.chat.MessageResponse;
import org.mule.extensions.client.model.file.FileUploadResponse;
import org.mule.functional.junit4.ExtensionFunctionalTestCase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SlackExtensionTestCase extends ExtensionFunctionalTestCase {

    public static final String TEXT_MESSAGE = "Best connector ever!";

    @Override
    protected Class<?>[] getAnnotatedExtensionClasses() {
        return new Class<?>[] { SlackExtension.class };
    }

    @Override
    protected String getConfigFile() {
        return "slack-test.xml";
    }

    @Ignore
    @Test
    public void testSource() throws Exception {
        startFlow("retrieve-events");
        Thread.sleep(20000);
    }

    @Test
    public void sendMessage() throws Exception {
        final MuleEvent muleEvent = flowRunner("send-message").withPayload(TEXT_MESSAGE).run();

        MessageResponse payload = (MessageResponse) muleEvent.getMessage().getPayload();
        assertThat(TEXT_MESSAGE, is(payload.getMessage().getText()));
    }

    @Test
    public void testSendFile() throws Exception {
        InputStream stream = new ByteArrayInputStream(TEXT_MESSAGE.getBytes(StandardCharsets.UTF_8));
        final MuleEvent muleEvent = flowRunner("send-file").withPayload(stream).run();

        FileUploadResponse payload = (FileUploadResponse) muleEvent.getMessage().getPayload();
        assertThat(TEXT_MESSAGE, is(payload.getPreview()));
    }

    private void startFlow(String flowName) throws Exception {
        ((Flow) getFlowConstruct(flowName)).start();
    }

}
