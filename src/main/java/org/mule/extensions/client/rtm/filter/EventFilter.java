package org.mule.extensions.client.rtm.filter;

import java.util.Map;

public interface EventFilter {

    boolean shouldAccept(Map<String, Object> message);

}
