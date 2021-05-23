
package com.ramkarlapudi.userapilive.commentaryDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Overs {

    public List<MyArray> myArrayList = null;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<MyArray> getMyArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(List<MyArray> myArrayList) {
        this.myArrayList = myArrayList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
