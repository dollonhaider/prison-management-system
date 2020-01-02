package com.prisonManagementSystem.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DateTimeException;
@Document

public class Visitor {
    @Id
    private ObjectId id;
    private String visitorName ;
    private int visitorNidNo ;
    private Prisoner prisoner ;
    private String relationship ;
    private String entryTime ;
    private String exitTime;
    private String status;


    public Visitor() {
    }


    public Visitor(ObjectId id, String visitorName, int visitorNidNo, Prisoner prisoner, String relationship, String entryTime, String exitTime, String status) {
        this.id = id;
        this.visitorName = visitorName;
        this.visitorNidNo = visitorNidNo;
        this.prisoner = prisoner;
        this.relationship = relationship;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.status = status;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public int getVisitorNidNo() {
        return visitorNidNo;
    }

    public void setVisitorNidNo(int visitorNidNo) {
        this.visitorNidNo = visitorNidNo;
    }

    public Prisoner getPrisonerId() {
        return prisoner;
    }

    public void setPrisonerId(Prisoner prisonerId) {
        this.prisoner = prisoner;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
