
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class LiveStreams {

	public List<Object> myArrayList = null;
	public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Object> getMyArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(List<Object> myArrayList) {
        this.myArrayList = myArrayList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
