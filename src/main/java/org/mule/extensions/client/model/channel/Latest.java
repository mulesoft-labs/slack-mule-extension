/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */


package org.mule.extensions.client.model.channel;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Latest {

    @Expose
    private String type;
    @Expose
    private String user;
    @Expose
    private String text;
    @Expose
    private List<Attachment> attachments = new ArrayList<Attachment>();
    @Expose
    private String ts;

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     *     The user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     *     The attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     *
     * @param attachments
     *     The attachments
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    /**
     *
     * @return
     *     The ts
     */
    public String getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     *     The ts
     */
    public void setTs(String ts) {
        this.ts = ts;
    }

}
