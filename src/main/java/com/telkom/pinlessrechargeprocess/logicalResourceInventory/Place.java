
package com.telkom.pinlessrechargeprocess.logicalResourceInventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "geoLocationUrl",
    "name",
    "role"
})
public class Place {

    @JsonProperty("address")
    private String address;
    @JsonProperty("geoLocationUrl")
    private String geoLocationUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("role")
    private String role;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("geoLocationUrl")
    public String getGeoLocationUrl() {
        return geoLocationUrl;
    }

    @JsonProperty("geoLocationUrl")
    public void setGeoLocationUrl(String geoLocationUrl) {
        this.geoLocationUrl = geoLocationUrl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

}
