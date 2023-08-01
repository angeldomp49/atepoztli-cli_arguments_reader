package org.makechtec.software.cli_arguments_reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CLIArgumentBufferTest {

    private CLIArgumentBuffer buffer;

    @BeforeEach
    public void setUp() {

        buffer = new CLIArgumentBuffer();

        buffer.loadArgumentKeys(Stream.of("stored_procedure_file").collect(Collectors.toSet()));


    }

    @Test
    public void testReading() {

        buffer.storeArguments(new String[]{"--stored_procedure_file=procedures.properties"});

        assertTrue(buffer.getArgumentValue("stored_procedure_file").isPresent());
        assertEquals("procedures.properties", buffer.getArgumentValue("stored_procedure_file").get());
    }
}
