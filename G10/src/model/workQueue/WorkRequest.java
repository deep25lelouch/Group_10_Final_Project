/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.workQueue;
//Rijurik_Saha_002525961
import model.userAccount.UserAccount;
import model.location.Location;
import util.enums.IssueType;
import util.enums.Priority;
import util.enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public class WorkRequest {

    private String requestId;
    private String description;
    private IssueType issueType;
    private Priority priority;
    private Status status;
    private Location location;
    private Date requestDate;
    private Date resolveDate;
    private UserAccount sender;
    private UserAccount receiver;
    private List<WorkNote> notes;
    private List<WorkRequest> linkedRequests; // For cross-enterprise collaboration
    private String citizenId;

    public WorkRequest() {
        this.requestId = "WR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.requestDate = new Date();
        this.status = Status.NEW;
        this.notes = new ArrayList<>();
        this.linkedRequests = new ArrayList<>();
    }

    public void addNote(String note, UserAccount user) {
        WorkNote workNote = new WorkNote(note, user);
        notes.add(workNote);
    }

    public void linkRequest(WorkRequest request) {
        linkedRequests.add(request);
    }

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public List<WorkNote> getNotes() {
        return notes;
    }

    public List<WorkRequest> getLinkedRequests() {
        return linkedRequests;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }
}
