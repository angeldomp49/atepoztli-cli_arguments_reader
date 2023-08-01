package org.makechtec.software.cli_arguments_reader.testing;

import org.makechtec.software.cli_arguments_reader.CLIArgumentBuffer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        CLIArgumentBuffer buffer = new CLIArgumentBuffer();

        buffer.loadArgumentKeys(Stream.of("stored_procedure_file").collect(Collectors.toSet()));

        buffer.storeArguments(args);

        System.out.println(buffer.getArgumentValue("stored_procedure_file").orElse("not found"));
    }

}
