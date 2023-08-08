package org.makechtec.software.property_reader;

import org.junit.jupiter.api.Test;
import org.makechtec.path_generator.PathGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PropertyReaderTest {

    @Test
    void loadArguments() {

        var pathGenerator = new PathGenerator();
        var resourcePath = pathGenerator.resourcePath(PropertyReaderTest.class, "test.properties");
        var propertyReader = new PropertyReader(resourcePath);


        propertyReader.loadArgumentKeys(Arrays.asList("db_name", "db_user"));

        propertyReader.loadArguments();

        assertTrue(propertyReader.getArgumentValue("db_name").isPresent());
        assertEquals("hello", propertyReader.getArgumentValue("db_name").get());

    }

    @Test
    void loadArguments_notFound() {

        var pathGenerator = new PathGenerator();
        var resourcePath = pathGenerator.resourcePath(PropertyReaderTest.class, "test.properties");
        var propertyReader = new PropertyReader(resourcePath);


        propertyReader.loadArgumentKeys(Arrays.asList("db_name_hello", "db_user"));

        propertyReader.loadArguments();

        assertFalse(propertyReader.getArgumentValue("db_name_hello").isPresent());

    }
}