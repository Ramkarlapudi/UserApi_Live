
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Map__6 {

    public String shieldImageUrl;
    public String name;
    public Integer id;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getShieldImageUrl() {
        return shieldImageUrl;
    }

    public void setShieldImageUrl(String shieldImageUrl) {
        this.shieldImageUrl = shieldImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
