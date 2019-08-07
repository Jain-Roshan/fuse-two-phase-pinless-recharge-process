
package com.telkom.pinlessrechargeprocess.logicalResourceInventory;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@baseType",
    "@schemaLocation",
    "@type",
    "category",
    "description",
    "endDate",
    "lifecycleState",
    "name",
    "startDate",
    "version",
    "value",
    "resourceRelationship",
    "characteristic",
    "place",
    "partyRole",
    "relatedParty",
    "note"
})
public class LogicalResourceInventory {

    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("category")
    private String category;
    @JsonProperty("description")
    private String description;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("lifecycleState")
    private String lifecycleState;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("version")
    private String version;
    @JsonProperty("value")
    private String value;
    @JsonProperty("resourceRelationship")
    private List<ResourceRelationship> resourceRelationship = null;
    @JsonProperty("characteristic")
    private List<Characteristic> characteristic = null;
    @JsonProperty("place")
    private Place place;
    @JsonProperty("partyRole")
    private List<PartyRole> partyRole = null;
    @JsonProperty("relatedParty")
    private List<RelatedParty> relatedParty = null;
    @JsonProperty("note")
    private List<Note> note = null;

    @JsonProperty("@baseType")
    public String getBaseType() {
        return baseType;
    }

    @JsonProperty("@baseType")
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    @JsonProperty("@schemaLocation")
    public String getSchemaLocation() {
        return schemaLocation;
    }

    @JsonProperty("@schemaLocation")
    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("lifecycleState")
    public String getLifecycleState() {
        return lifecycleState;
    }

    @JsonProperty("lifecycleState")
    public void setLifecycleState(String lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("resourceRelationship")
    public List<ResourceRelationship> getResourceRelationship() {
        return resourceRelationship;
    }

    @JsonProperty("resourceRelationship")
    public void setResourceRelationship(List<ResourceRelationship> resourceRelationship) {
        this.resourceRelationship = resourceRelationship;
    }

    @JsonProperty("characteristic")
    public List<Characteristic> getCharacteristic() {
        return characteristic;
    }

    @JsonProperty("characteristic")
    public void setCharacteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }

    @JsonProperty("place")
    public Place getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(Place place) {
        this.place = place;
    }

    @JsonProperty("partyRole")
    public List<PartyRole> getPartyRole() {
        return partyRole;
    }

    @JsonProperty("partyRole")
    public void setPartyRole(List<PartyRole> partyRole) {
        this.partyRole = partyRole;
    }

    @JsonProperty("relatedParty")
    public List<RelatedParty> getRelatedParty() {
        return relatedParty;
    }

    @JsonProperty("relatedParty")
    public void setRelatedParty(List<RelatedParty> relatedParty) {
        this.relatedParty = relatedParty;
    }

    @JsonProperty("note")
    public List<Note> getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(List<Note> note) {
        this.note = note;
    }

}
