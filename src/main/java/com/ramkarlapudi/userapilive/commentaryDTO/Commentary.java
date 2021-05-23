
package com.ramkarlapudi.userapilive.commentaryDTO;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Commentary {

    public com.ramkarlapudi.userapilive.commentaryDTO.Map map;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public com.ramkarlapudi.userapilive.commentaryDTO.Map getMap() {
        return map;
    }

    public void setMap(com.ramkarlapudi.userapilive.commentaryDTO.Map map) {
        this.map = map;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
