package org.mule.extensions;

import org.mule.metadata.api.model.MetadataType;
import org.mule.metadata.java.JavaTypeLoader;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataKeyBuilder;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.MetadataContentResolver;
import org.mule.runtime.api.metadata.resolving.MetadataKeysResolver;
import org.mule.runtime.api.metadata.resolving.MetadataOutputResolver;

import java.util.Collections;
import java.util.List;

public class KeysResolver implements MetadataOutputResolver, MetadataKeysResolver, MetadataContentResolver {

    @Override
    public List<MetadataKey> getMetadataKeys(MetadataContext metadataContext) throws MetadataResolvingException, ConnectionException {
        final MetadataKey build = MetadataKeyBuilder.newKey("Hi").withDisplayName("Hola").build();
        return Collections.singletonList(build);
    }

    @Override
    public MetadataType getOutputMetadata(MetadataContext metadataContext, MetadataKey metadataKey) throws MetadataResolvingException, ConnectionException {
        return new JavaTypeLoader(this.getClass().getClassLoader()).load(Person.class);
    }

    @Override
    public MetadataType getContentMetadata(MetadataContext metadataContext, MetadataKey metadataKey) throws MetadataResolvingException, ConnectionException {
        return new JavaTypeLoader(this.getClass().getClassLoader()).load(Person.class);
    }
}
