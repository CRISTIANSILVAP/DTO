package edu.eci.cvds.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "Reservation")
public class Reservation {
    @Id
    private String id;
    private Laboratory laboratory;
    private User user;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String purpose;
    private boolean status;

    public Reservation() {}

    public Reservation(Laboratory laboratory, User user, LocalDateTime startDateTime, LocalDateTime endDateTime, String purpose,boolean status) {
        this.laboratory = laboratory;
        this.user = user;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.purpose = purpose;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Laboratory getLaboratoryId() {
        return laboratory;
    }
    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public User getUser() {return user;}

    public void setStatus(boolean status) {this.status = status;}

    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
