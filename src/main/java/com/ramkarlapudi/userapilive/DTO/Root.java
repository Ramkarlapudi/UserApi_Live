
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Root {

    public com.ramkarlapudi.userapilive.DTO.Map map;
    public java.util.Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public com.ramkarlapudi.userapilive.DTO.Map getMap() {
        return map;
    }

    public void setMap(com.ramkarlapudi.userapilive.DTO.Map map) {
        this.map = map;
    }

    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
