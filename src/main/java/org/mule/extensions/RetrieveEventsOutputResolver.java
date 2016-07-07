package org.mule.extensions;

import static org.mule.metadata.api.model.MetadataFormat.JAVA;

import org.mule.metadata.api.builder.BaseTypeBuilder;
import org.mule.metadata.api.model.MetadataType;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.MetadataOutputResolver;
import org.mule.runtime.extension.api.introspection.metadata.NullMetadataKey;

public class RetrieveEventsOutputResolver implements MetadataOutputResolver<NullMetadataKey>
{

    @Override
    public MetadataType getOutputMetadata(MetadataContext context, NullMetadataKey key) throws MetadataResolvingException, ConnectionException
    {
        return BaseTypeBuilder.create(JAVA).objectType().build();
    }
}
