package org.makechtec.software.property_reader;

import org.makechtec.software.argument_reader.ArgumentAutoLoader;
import org.makechtec.software.properties_loader.AbsolutePathPropertyLoader;

import java.util.*;

public class PropertyReader implements ArgumentAutoLoader {

    private final Collection<String> keys;
    private final String propertyFilename;

    private final Map<String, Optional<String>> values;

    public PropertyReader(String propertyFilename) {
        this.keys = new HashSet<>();
        this.values = new HashMap<>();
        this.propertyFilename = propertyFilename;
    }


    @Override
    public void loadArgumentKeys(Collection<String> keys) {
        this.keys.addAll(keys);
    }

    @Override
    public Optional<String> getArgumentValue(String key) {
        return Objects.nonNull(values.get(key)) ? values.get(key) : Optional.empty();
    }

    @Override
    public void loadArguments() {

        var propertyLoader = new AbsolutePathPropertyLoader(this.propertyFilename);

        keys.forEach(key -> values.put(key, propertyLoader.getProperty(key)));

    }
}
