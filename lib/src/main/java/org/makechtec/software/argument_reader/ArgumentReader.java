package org.makechtec.software.argument_reader;

import java.util.Collection;
import java.util.Optional;

public interface ArgumentReader {
    void loadArgumentKeys(Collection<String> keys);

    Optional<String> getArgumentValue(String key);

}
