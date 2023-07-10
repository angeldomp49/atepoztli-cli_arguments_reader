package org.makechtec.software.cli_arguments_reader;

import java.util.*;

public class CLIArgumentBuffer {

    private final Map<String, Optional<String>> argumentMap;
    private final Set<String> argumentKeys;

    public CLIArgumentBuffer() {
        argumentMap = new HashMap<>();
        argumentKeys = new HashSet<>();
    }

    public void loadArgumentKeys(Set<String> keys){
        argumentKeys.addAll(keys);
    }

    public void storeArguments(String[] args){

        Arrays.stream(args).forEach(System.out::println);

        argumentKeys.forEach(key -> {

            var patternFormat = "--" + key + '=';

            var argumentValue =
                    Arrays.stream(args)
                            .filter( argument -> argument.startsWith(patternFormat))
                            .map( argumentMatch -> argumentMatch.replace(patternFormat, "") )
                            .findFirst();
            argumentMap.put(key, argumentValue);
        });

    }

    public Optional<String> getArgumentValue(String key) {
        return Objects.nonNull(argumentMap.get(key)) ? argumentMap.get(key) : Optional.empty();
    }

}
