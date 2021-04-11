
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Map {

    public Match match;
    public String poweredBy;
    public Integer status;
    public java.util.Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getPoweredBy() {
        return poweredBy;
    }

    public void setPoweredBy(String poweredBy) {
        this.poweredBy = poweredBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
