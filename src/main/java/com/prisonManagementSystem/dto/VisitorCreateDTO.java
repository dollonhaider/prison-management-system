package com.prisonManagementSystem.dto;

import com.prisonManagementSystem.model.Prisoner;
import org.bson.types.ObjectId;


public class VisitorCreateDTO {

    private String visitorName ;
    private int visitorNidNo ;
    private String prisoner ;
    private String relationship ;
    private String entryTime ;
    private String exitTime;

    public VisitorCreateDTO() {
    }

    public VisitorCreateDTO(String visitorName, int visitorNidNo, String prisoner, String relationship, String entryTime, String exitTime) {
        this.visitorName = visitorName;
        this.visitorNidNo = visitorNidNo;
        this.prisoner = prisoner;
        this.relationship = relationship;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
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

    public String getPrisonerId() {
        return prisoner;
    }

    public void setPrisonerId(String prisonerId) {
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
}
