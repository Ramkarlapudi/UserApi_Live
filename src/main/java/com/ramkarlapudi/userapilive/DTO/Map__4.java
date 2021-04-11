
package com.ramkarlapudi.userapilive.DTO;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Map__4 {

    public String homeOvers;
    public String awayOvers;
    public String homeScore;
    public String awayScore;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getHomeOvers() {
        return homeOvers;
    }

    public void setHomeOvers(String homeOvers) {
        this.homeOvers = homeOvers;
    }

    public String getAwayOvers() {
        return awayOvers;
    }

    public void setAwayOvers(String awayOvers) {
        this.awayOvers = awayOvers;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
