package com.prisonManagementSystem.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class Prisoner {


    @Id
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
    private String status;
    private Section section;


    public Prisoner() {
    }


    public Prisoner(ObjectId id, String name, String uniqueName, String fatherName, int age, String address, String dateOfIn, String dateOfOut, String caseType, String caseYear, String status, Section section) {
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
        this.status = status;
        this.section = section;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
