package com.ibragimov.apptaskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import com.ibragimov.apptaskmanagement.model.template.UUIDModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace extends LongModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;

    @ManyToOne
    private Attachment avatar;

    @Column(nullable = false)
    private String initialLetter;

    @PrePersist
    @PreUpdate
    public void setInitialLetter() {
        this.initialLetter = name.substring(0, 1).toUpperCase();
    }

    public Workspace(String name, String color, User owner, Attachment avatar) {
        this.name = name;
        this.color = color;
        this.owner = owner;
        this.avatar = avatar;
    }

}
