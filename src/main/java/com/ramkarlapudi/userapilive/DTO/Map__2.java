
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Map__2 {

    public String antisocialPhoneNumber;
    public String latitude;
    public String name;
    public String location;
    public String longitude;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAntisocialPhoneNumber() {
        return antisocialPhoneNumber;
    }

    public void setAntisocialPhoneNumber(String antisocialPhoneNumber) {
        this.antisocialPhoneNumber = antisocialPhoneNumber;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
