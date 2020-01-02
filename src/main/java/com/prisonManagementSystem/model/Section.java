package com.prisonManagementSystem.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Section {
    @Id
    private ObjectId id;
    private String sectionName;
    private int noOfPrisoners;
    private String status;

    public Section() {
    }

    public Section(ObjectId id, String sectionName, int noOfPrisoners, String status) {
        this.id = id;
        this.sectionName = sectionName;
        this.noOfPrisoners = noOfPrisoners;
        this.status = status;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getNoOfPrisoners() {
        return noOfPrisoners;
    }

    public void setNoOfPrisoners(int noOfPrisoners) {
        this.noOfPrisoners = noOfPrisoners;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
