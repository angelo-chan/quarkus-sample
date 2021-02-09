package org.acme.sample.object.base;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RegisterForReflection
public class PageResult<T> {

    int index;

    int size;

    List<T> data;

    long total;

}
