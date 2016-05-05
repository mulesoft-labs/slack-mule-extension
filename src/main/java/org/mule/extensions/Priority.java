package org.mule.extensions;

/**
 * Created by estebanwasinger on 3/12/16.
 */
public enum Priority
{
    HTTP("http", 80), HTTPS("https", 443);

    private final String scheme;
    private final int defaultPort;

    Priority(String scheme, int defaultPort)
    {
        this.scheme = scheme;
        this.defaultPort = defaultPort;
    }

    public String getScheme()
    {
        return scheme;
    }

    public int getDefaultPort()
    {
        return defaultPort;
    }
}