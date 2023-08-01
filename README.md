## Requirements ##

- java 17+

## Dependency ##

__Maven__

    <dependency>
        <groupId>org.makechtec.software</groupId>
        <artifactId>cli_arguments_reader</artifactId>
        <version>1.2.0</version>
    </dependency>

__Gradle__

    implementation 'org.makechtec.software:cli_arguments_reader:1.2.0'

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

## System variable reader ##

## USAGE ##

    var reader = new SystemVariableReader();

    var keys = new HashSet<String>();

    keys.add("db_name");

    reader.loadArgumentKeys(keys);
    reader.loadArguments();
    var dbName = reader.getArgumentValue("db_name");

    assertTrue(dbName.isPresent());
    assertEquals("test", dbName.get());

## Property reader ##

## USAGE ##

    var pathGenerator = new PathGenerator();
    var resourcePath = pathGenerator.resourcePath(PropertyReaderTest.class, "test.properties");
    var propertyReader = new PropertyReader(resourcePath);


    propertyReader.loadArgumentKeys(Arrays.asList( "db_name", "db_user" ));

    propertyReader.loadArguments();

    assertTrue(propertyReader.getArgumentValue("db_name").isPresent());
    assertEquals("hello", propertyReader.getArgumentValue("db_name").get());
