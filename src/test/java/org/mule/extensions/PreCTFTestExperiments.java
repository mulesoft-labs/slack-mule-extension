/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions;

import org.junit.Test;

public class PreCTFTestExperiments { //extends AbstractExtensionTestCase<SlackExtension> {
    @Test
    public void test(){
        String string = ", !, \", #, $, %, &, ', (, ), *, +, ,, /, :, ;, <, =, >, ?, @, [, \\, ], ^, `, {, |, }, ~";
        System.out.println(string.replaceAll("[ \\\\\\[!\"#$%&'\\(\\)*+,/:;<=>?@\\]^`{|}~]",""));
    }

//    public PreCTFTestExperiments() {
//        super(SlackExtension.class);
//    }
//
//    //    @Override
//    //    protected Class<?>[] getAnnotatedExtensionClasses() {
//    //        return new Class<?>[] { SlackExtension.class };
//    //    }
//    //
//    //    @Override
//    //    protected String getConfigFile() {
//    //        return "slack-test.xml";
//    //    }
//
//    @Test
//    public void testSource() throws Exception {
//        final AnnotationsBasedDescriber annotationsBasedDescriber = new AnnotationsBasedDescriber(SlackExtension.class);
//        final Descriptor describe = annotationsBasedDescriber.describe(new DefaultDescribingContext());
//
//        //        final DefaultExtensionManager extensionManager = new DefaultExtensionManager();
//        //        final List<ExtensionModel> extensionModels = extensionManager.discoverExtensions(getClass().getClassLoader());
//        System.out.println("hola");
//    }

    //    @Test
    //    public void testDummy() throws Exception {
    //        MuleEvent muleEvent = runFlow("dummy");
    //        MessageResponse payload = (MessageResponse) muleEvent.getMessage().getPayload();
    //        assertEquals("Hey!", payload.getMessage().getText());
    //    }
    //
    //    @Test
    //    public void testSendFile() throws Exception {
    //        String text = "Text as inputStream";
    //        InputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    //        MuleEvent muleEvent = runFlow("send-file", stream);
    //        FileUploadResponse payload = (FileUploadResponse) muleEvent.getMessage().getPayload();
    //        assertEquals("Text as inputStream", payload.getPreview());
    //    }

    //    private void startFlow(String flowName) throws Exception {
    //        ((Flow) getFlowConstruct(flowName)).start();
    //    }

}
