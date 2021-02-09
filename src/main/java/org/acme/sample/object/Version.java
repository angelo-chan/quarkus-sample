package org.acme.sample.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Version {

    String name;

    String version;

    String profile;

    String branch;

    String buildTime;

    String commitId;
    
}
