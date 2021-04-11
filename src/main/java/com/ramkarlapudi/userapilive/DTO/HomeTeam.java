
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class HomeTeam {

	public Map__5 map;
	public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map__5 getMap() {
        return map;
    }

    public void setMap(Map__5 map) {
        this.map = map;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
