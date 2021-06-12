package com.dgc.DiscGolfLeagues.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @Column(name = "published")
    private boolean published;
    @Column(name = "tags")
    private boolean tags;
    @Column(name = "general_divisions")
    private boolean generalDivisions;
    @Column(name = "cards_built")
    private boolean cardsBuilt;

//    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "event_player", joinColumns = {
            @JoinColumn(name = "event_id", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "player_id", nullable = false, updatable = false) })
    private Set<Player> players;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventType eventType;

    public Event() {

    }

    public Event(String title, String description, boolean published, boolean generalDivisions, boolean tags, boolean cardsBuilt, EventType eventType) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.tags = tags;
        this.generalDivisions = generalDivisions;
        this.eventType = eventType;
        this.cardsBuilt = cardsBuilt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public boolean isGeneralDivisions() {
        return generalDivisions;
    }

    public void setGeneralDivisions(boolean generalDivisions) {
        this.generalDivisions = generalDivisions;
    }

    public boolean isTags() {
        return tags;
    }

    public void setTags(boolean tags) {
        this.tags = tags;
    }

    public boolean isCardsBuilt() {
        return cardsBuilt;
    }

    public void setCardsBuilt(boolean cardsBuilt) {
        this.cardsBuilt = cardsBuilt;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
