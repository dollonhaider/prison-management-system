package com.prisonManagementSystem.dto;

import com.prisonManagementSystem.enums.Authority;
import org.bson.types.ObjectId;

public class SectionUpdateDTO {
    private ObjectId id;
    private String sectionName;
    private int noOfPrisoners;

    public SectionUpdateDTO() {
    }

    public SectionUpdateDTO(ObjectId id, String sectionName, int noOfPrisoners) {
        this.id = id;
        this.sectionName = sectionName;
        this.noOfPrisoners = noOfPrisoners;
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
}
