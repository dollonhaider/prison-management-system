package com.prisonManagementSystem.dto;

import org.bson.types.ObjectId;

public class SectionCreateDTO {

    private String sectionName;
    private int noOfPrisoners;

    public SectionCreateDTO() {
    }

    public SectionCreateDTO(String sectionName, int noOfPrisoners) {
        this.sectionName = sectionName;
        this.noOfPrisoners = noOfPrisoners;
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
