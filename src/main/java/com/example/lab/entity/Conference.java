package com.example.lab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Conference extends Event{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_id")
    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
