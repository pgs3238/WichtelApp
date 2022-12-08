package Eventverwaltung.Event.entity.internal;

import Eventverwaltung.Event.entity.EventTO;
import Eventverwaltung.Teilnehmer.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "wichtel_event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int EventId;
    private String name;
    private String regeln;
    private LocalDateTime deadline;
    private LocalDateTime eventDate;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(joinColumns = @JoinColumn(name = "Event_EventId", referencedColumnName = "eventId"))
    private Collection<User> mitglieder;

    public Event(int eventId, String name, String regeln, LocalDateTime deadline, LocalDateTime eventDate, Collection<User> mitglieder) {
        EventId = eventId;
        this.name = name;
        this.regeln = regeln;
        this.deadline = deadline;
        this.eventDate = eventDate;
        this.mitglieder = mitglieder;
    }

    public Event(){

    }

    public EventTO toEventTO(){
        EventTO eventTO = new EventTO();

        eventTO.setEventId(this.EventId);
        eventTO.setName(this.name);
        eventTO.setRegeln(this.regeln);
        eventTO.setEventDate(this.eventDate);
        eventTO.setDeadline(this.deadline);
        return eventTO;
    }

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegeln() {
        return regeln;
    }

    public void setRegeln(String regeln) {
        this.regeln = regeln;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Collection<User> getMitglieder() {
        return mitglieder;
    }

    public void setMitglieder(Collection<User> mitglieder) {
        this.mitglieder = mitglieder;
    }
}