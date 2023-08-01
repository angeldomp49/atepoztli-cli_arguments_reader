package org.makechtec.software.system_variable_reader;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SystemVariableReaderTest {


    @Test
    void getArgumentValue() {

        var reader = new SystemVariableReader();

        var keys = new HashSet<String>();

        keys.add("db_name");

        reader.loadArgumentKeys(keys);
        reader.loadArguments();
        var dbName = reader.getArgumentValue("db_name");

        assertTrue(dbName.isPresent());
        assertEquals("test", dbName.get());

    }

    @Test
    void getArgumentValue_notFound() {

        var reader = new SystemVariableReader();

        var keys = new HashSet<String>();

        keys.add("db_name_hello");

        reader.loadArgumentKeys(keys);
        reader.loadArguments();
        var dbName = reader.getArgumentValue("db_name_hello");

        assertFalse(dbName.isPresent());

    }

}