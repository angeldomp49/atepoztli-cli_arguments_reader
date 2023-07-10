
## Requirements ##

- java 17+

## Dependency ##

__Maven__

    <dependency>
        <groupId>org.makechtec.software</groupId>
        <artifactId>cli_arguments_reader</artifactId>
        <version>1.0.0</version>
    </dependency>

__Gradle__

    implementation 'org.makechtec.software:cli_arguments_reader:1.0.0'

## Usage ##

__Example read main args__

Consider the arguments:

    java -cp app.jar org.makechtec.App --store_procedure_file=procedures.properties

And with code:

    package org.makechtec;

    public class App {

        public static void main(String[] args){
    
            CLIArgumentBuffer buffer = new CLIArgumentBuffer();
        
            buffer.loadArgumentKeys(Stream.of("stored_procedure_file").collect(Collectors.toSet()));
        
            buffer.storeArguments(args);
    
            assertTrue(buffer.getArgumentValue("stored_procedure_file").isPresent());
            assertEquals("procedures.properties", buffer.getArgumentValue("stored_procedure_file").get());
    
        }
    
    }