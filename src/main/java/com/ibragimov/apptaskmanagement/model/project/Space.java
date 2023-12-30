package com.ibragimov.apptaskmanagement.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibragimov.apptaskmanagement.model.enums.AccessType;
import com.ibragimov.apptaskmanagement.model.files.Attachment;
import com.ibragimov.apptaskmanagement.model.files.Icon;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
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
public class Space extends LongModel {

    private String name;

    private String color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Workspace workspace;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Icon icon;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @Column(nullable = false)
    private String initialLetter;

    @PrePersist
    @PreUpdate
    private void  setInitialLetterFromName(){
        this.initialLetter=name.substring(0,1).toUpperCase();
    }


    public Space(String name, String color, Workspace workspace, Icon icon, Attachment avatar, User owner, AccessType accessType) {
        this.name = name;
        this.color = color;
        this.workspace = workspace;
        this.icon = icon;
        this.avatar = avatar;
        this.owner = owner;
        this.accessType = accessType;
    }

}
