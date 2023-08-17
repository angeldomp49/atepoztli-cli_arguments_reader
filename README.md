# cli_arguments_reader #

## Requirements ##

    - java 17

## Dependency ##

Maven

    <dependency>
        <groupId>org.makechtec.software</groupId>
        <artifactId>cli_arguments_reader</artifactId>
        <version>2.0.0</version>
    </dependency>

Gradle groovy

    implementation "org.makechtec.software:cli_arguments_reader:2.0.0"

Gradle kotlin

    implementation("org.makechtec.software:cli_arguments_reader:2.0.0")

## Usage ##

There are three implementations for __ArgumentAutoLoader__ interface, this file contains the following methods:

    void loadArgumentKeys(Collection<String> keys);

    Optional<String> getArgumentValue(String key);

    void loadArguments();

The next three sections are the corresponding implementations used to extract variables from different sources.

___

CLIArgumentBuffer:

        ArgumentAutoLoader buffer = new CLIArgumentBuffer();

        buffer.loadArgumentKeys(Stream.of("stored_procedure_file").collect(Collectors.toSet()));

        buffer.storeArguments(new String[]{"--stored_procedure_file=procedures.properties"});

        Optional<String> value = buffer.getArgumentValue("stored_procedure_file";

        System.out.println(value.get());

        // output: 
        // procedures.properties
        
SystemVariableReader:

First let's suppose there is an environment variable __db_name__:

        export db_name=test

Then:

        ArgumentAutoLoader reader = new SystemVariableReader();

        var keys = new HashSet<String>();

        keys.add("db_name");

        reader.loadArgumentKeys(keys);
        reader.loadArguments();
        Optional<String> dbName = reader.getArgumentValue("db_name");

        System.out.println(dbName.get());

        // output: 
        // test

PropertyReader

As before let's suppose there is a test.properties file in the resource directory with the content above:

        db_name=hello
        db_user=hello_user

Then:

        var pathGenerator = new PathGenerator();
        var resourcePath = pathGenerator.resourcePath(PropertyReaderTest.class, "test.properties");

        ArgumentAutoLoader propertyReader = new PropertyReader(resourcePath);


        propertyReader.loadArgumentKeys(Arrays.asList("db_name", "db_user"));

        propertyReader.loadArguments();

        Optional<String> dbName = propertyReader.getArgumentValue("db_name");

        System.out.println(dbName.get());

        // output: 
        // hello