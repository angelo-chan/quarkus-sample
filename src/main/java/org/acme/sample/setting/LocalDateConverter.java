package org.acme.sample.setting;

import javax.ws.rs.ext.ParamConverter;
import java.time.LocalDate;

/**
 * Local date converter
 */
public class LocalDateConverter implements ParamConverter<LocalDate> {

    @Override
    public LocalDate fromString(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String toString(LocalDate value) {
        return value.toString();
    }
}
