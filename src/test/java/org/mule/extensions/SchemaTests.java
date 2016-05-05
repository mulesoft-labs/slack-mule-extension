package org.mule.extensions;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SchemaTests
{

    private Validator validator;

    @Before
    public void validateSchema() throws IOException, SAXException
    {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        final Schema schema = schemaFactory.newSchema(new Source[] {
                new StreamSource(new FileInputStream(new File("/Users/estebanwasinger/Documents/workspace/mulesoft/sdk/mule/modules/spring-config/src/main/resources/META-INF/mule.xsd"))),
                new StreamSource(new FileInputStream(new File("/Users/estebanwasinger/Desktop/idea/standardSchemas/XMLSchema.xsd"))),
                new StreamSource(new FileInputStream(new File("/Users/estebanwasinger/Documents/workspace/mulesoft/sdk/mule/modules/extensions-spring-support/src/main/resources/META-INF/mule-extension.xsd"))),
                new StreamSource(new FileInputStream(new File("/Users/estebanwasinger/Documents/workspace/mulesoft/testConnectors/slack-mule-extension/target/classes/META-INF/mule-slack.xsd"))),
        });

        validator = schema.newValidator();
    }

    @Test
    public void validXML() throws IOException, SAXException
    {
        String validXml = "<slack:token token=\"${slack.token}\" name=\"token-config\" xmlns:mule=\"http://www.mulesoft.org/schema/mule/core\" xmlns:slack=\"http://www.mulesoft.org/schema/mule/slack\">\n" +
                          "        <slack:pooled-connection disableValidation=\"true\" someValue=\"hola\">\n" +
                          "            <mule:reconnect/>\n" +
                          "            <mule:pooling-profile/>\n" +
                          "        </slack:pooled-connection>\n" +
                          "    </slack:token>\n";
        final StreamSource streamSource = getStreamSourceFromString(validXml);

        validator.validate(streamSource);
    }

    @Test
    public void validXMLNoChildElements() throws IOException, SAXException
    {
        String validXml = "<slack:token token=\"${slack.token}\" name=\"token-config\" xmlns:mule=\"http://www.mulesoft.org/schema/mule/core\" xmlns:slack=\"http://www.mulesoft.org/schema/mule/slack\">\n" +
                          "        <slack:pooled-connection disableValidation=\"true\" someValue=\"hola\">\n" +
                          "            <mule:pooling-profile/>\n" +
                          "        </slack:pooled-connection>\n" +
                          "    </slack:token>\n";
        final StreamSource streamSource = getStreamSourceFromString(validXml);

        validator.validate(streamSource);
    }

    @Test(expected = SAXParseException.class)
    public void invalidXMLDuplicatedElement() throws IOException, SAXException
    {
        String validXml = "<slack:token token=\"${slack.token}\" name=\"token-config\" xmlns:mule=\"http://www.mulesoft.org/schema/mule/core\" xmlns:slack=\"http://www.mulesoft.org/schema/mule/slack\">\n" +
                          "        <slack:pooled-connection disableValidation=\"true\" someValue=\"hola\">\n" +
                          "            <mule:reconnect/>\n" +
                          "            <mule:pooling-profile/>\n" +
                          "            <mule:pooling-profile/>\n" +
                          "        </slack:pooled-connection>\n" +
                          "    </slack:token>\n";
        final StreamSource streamSource = getStreamSourceFromString(validXml);

        validator.validate(streamSource);
    }

    @Test(expected = SAXParseException.class)
    public void invalidXMLBadOrder() throws IOException, SAXException
    {
        String validXml = "<slack:token token=\"${slack.token}\" name=\"token-config\" xmlns:mule=\"http://www.mulesoft.org/schema/mule/core\" xmlns:slack=\"http://www.mulesoft.org/schema/mule/slack\">\n" +
                          "        <slack:pooled-connection disableValidation=\"true\" someValue=\"hola\">\n" +
                          "            <mule:pooling-profile/>\n" +
                          "            <mule:reconnect/>\n" +
                          "        </slack:pooled-connection>\n" +
                          "    </slack:token>\n";
        final StreamSource streamSource = getStreamSourceFromString(validXml);

        validator.validate(streamSource);
    }

    private StreamSource getStreamSourceFromString(String validXml)
    {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(validXml.getBytes(StandardCharsets.UTF_8));
        return new StreamSource(byteArrayInputStream);
    }


}
