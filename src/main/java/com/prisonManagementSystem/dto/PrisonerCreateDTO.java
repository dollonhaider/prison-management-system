package com.prisonManagementSystem.dto;

import org.bson.types.ObjectId;

import java.util.Date;

public class PrisonerCreateDTO {

    private ObjectId id;
    private String name;
    private String uniqueName;
    private String fatherName;
    private int age;
    private String address;
    private String dateOfIn;
    private String dateOfOut;
    private String caseType;
    private String caseYear;
    private String sectionId;

    public PrisonerCreateDTO() {
    }

    public PrisonerCreateDTO(ObjectId id,String name, String uniqueName, String fatherName, int age, String address, String dateOfIn, String dateOfOut, String caseType, String caseYear, String sectionId) {
        this.id = id;
        this.name = name;
        this.uniqueName = uniqueName;
        this.fatherName = fatherName;
        this.age = age;
        this.address = address;
        this.dateOfIn = dateOfIn;
        this.dateOfOut = dateOfOut;
        this.caseType = caseType;
        this.caseYear = caseYear;
        this.sectionId = sectionId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfIn() {
        return dateOfIn;
    }

    public void setDateOfIn(String dateOfIn) {
        this.dateOfIn = dateOfIn;
    }

    public String getDateOfOut() {
        return dateOfOut;
    }

    public void setDateOfOut(String dateOfOut) {
        this.dateOfOut = dateOfOut;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseYear() {
        return caseYear;
    }

    public void setCaseYear(String caseYear) {
        this.caseYear = caseYear;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
}
