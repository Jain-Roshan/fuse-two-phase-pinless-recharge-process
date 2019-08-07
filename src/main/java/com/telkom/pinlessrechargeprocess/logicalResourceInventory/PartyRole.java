
package com.telkom.pinlessrechargeprocess.logicalResourceInventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "href",
    "id",
    "name",
    "partyId",
    "partyName"
})
public class PartyRole {

    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("partyId")
    private String partyId;
    @JsonProperty("partyName")
    private String partyName;

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @JsonProperty("partyName")
    public String getPartyName() {
        return partyName;
    }

    @JsonProperty("partyName")
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

}
