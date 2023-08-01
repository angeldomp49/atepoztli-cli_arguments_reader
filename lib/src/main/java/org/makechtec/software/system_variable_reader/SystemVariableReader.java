package org.makechtec.software.system_variable_reader;

import org.makechtec.software.argument_reader.ArgumentAutoLoader;

import java.util.*;

public class SystemVariableReader implements ArgumentAutoLoader {

    private final Collection<String> keys;
    private final Map<String, String> values;

    public SystemVariableReader() {
        this.keys = new HashSet<>();
        this.values = new HashMap<>();
    }

    public void loadArguments() {
        keys.forEach(key -> {

            var value = System.getenv(key);

            values.put(key, value);
        });
    }

    @Override
    public void loadArgumentKeys(Collection<String> keys) {
        this.keys.addAll(keys);
    }

    @Override
    public Optional<String> getArgumentValue(String key) {
        return Objects.nonNull(values.get(key)) ? Optional.of(values.get(key)) : Optional.empty();
    }

}
